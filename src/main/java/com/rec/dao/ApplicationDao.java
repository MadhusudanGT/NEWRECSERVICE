package com.rec.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicantModel;
import com.rec.model.ApplicationModel;
import com.rec.repository.ApplicationRepository;
import com.rec.util.Validation;
@Service
public class ApplicationDao {
	@Autowired
	ApplicationRepository apprepo;
     
	@Autowired
	Validation validation;
	public ApplicationModel Save(ApplicationModel app) {
		System.out.print("success"+ app);
		return apprepo.save(app);
	}
	
	public ResponseEntity<ApplicationModel> getApplicationById(Long appcid) throws ResourceNotFoundException{
		
		ApplicationModel status=apprepo.findById(appcid).orElseThrow(() -> new ResourceNotFoundException("application not found"));
		
		
		return ResponseEntity.ok().body(status);
		}
	
	public ApplicationModel updateapplication(Long id, ApplicationModel app) throws ResourceNotFoundException {
		ApplicationModel ApplicationModelOptional = apprepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("application not found for this id :: " + id));
         System.out.print("applicationmodeloptional"+ApplicationModelOptional);
        ApplicationModel updatedApplication;

        try {
	        
//	          if( (validation.isDOB((CharSequence) app.getAppliedDate())==true &&
//	        		  validation.isEducation(app.getEducation())==true)||
//	        		  (validation.isExperience(app.getExperience())==true &&
//	        		 validation.isOtherInfo(app.getOtherInfo())==true))
//	        		
//	        		  {
//	        	      System.out.println("successful");
//	        	      ApplicationModelOptional.setAppliedDate(app.getAppliedDate());
//	        	      ApplicationModelOptional.setEducation(app.getEducation());
//	        	      ApplicationModelOptional.setExperience(app.getExperience());
//	        	      ApplicationModelOptional.setOtherInfo(app.getOtherInfo());
//	     
		 			 updatedApplication = this.apprepo.save(app);
		 			return updatedApplication;
	         }
	       

//         else
//         {
//       	 System.out.print("Insert data properly");
//        }
        
//        }
        catch(Exception e) {
        	System.out.print("Exception found");
        }
        return null;
    	
	}
	
	public Map<String, Boolean> deleteapplication(Long appid) throws ResourceNotFoundException {
		ApplicationModel user = this.apprepo.findById(appid)
		.orElseThrow(() -> new ResourceNotFoundException("application not found for this id :: " + appid));
		
		this.apprepo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		}
}
