package com.rec.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicantModel;
import com.rec.model.RoleModel;
import com.rec.model.UserModel;
import com.rec.repository.ApplicantRepository;
import com.rec.util.UserValidation;
import com.rec.util.Validation;

@Service
public class ApplicantDao {
	@Autowired
	ApplicantRepository apprepo;
	@Autowired
	Validation validation;
	

	public ApplicantModel Save(ApplicantModel app) {
		System.out.print("success"+ app);
		return apprepo.save(app);
	}
	
	public ResponseEntity<ApplicantModel> getApplicantById(Long appid) throws ResourceNotFoundException{
	
		ApplicantModel status=apprepo.findById(appid).orElseThrow(() -> new ResourceNotFoundException("applicant not found"));
		
		
		return ResponseEntity.ok().body(status);
		}
	
//	@Override
	public ApplicantModel updateapplicant(Long id, ApplicantModel app) throws ResourceNotFoundException {
		ApplicantModel ApplicantModelOptional = apprepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("applicant not found for this id :: " + id));
         System.out.print("applicantmodeloptional"+ApplicantModelOptional);
        ApplicantModel updatedApplicant;

        try {
	        
//	          if( (validation.isLastName(app.getLastName())==true &&
//	        		  validation.isFirstName(app.getFirstName())==true)||
//	        		  (validation.isEmailId(app.getEmail())==true &&
//	        		   validation.isPhoneNo(app.getPhoneNo())==true)||
//	        		  validation.isSummary(app.getSummary())==true)
//	        		
//	        		  {
//	        	      System.out.println("successful");
		 			ApplicantModelOptional.setFirstName(app.getFirstName());
		 			ApplicantModelOptional.setLastName(app.getLastName());
		 			ApplicantModelOptional.setEmail(app.getEmail());
		 			ApplicantModelOptional.setPhoneNo(app.getPhoneNo());
		 			ApplicantModelOptional.setSummary(app.getSummary());
		 			
		 			
		 			 updatedApplicant = this.apprepo.save(app);
		 			return app;
	         }
	       

//         else
//         {
//       	 System.out.print("Insert data properly");
//        }
//        
//        }
        catch(Exception e) {
        	System.out.print("Exception found");
        }
        return null;
    	
	}
	
//	public void deleteapplicant(Long id) {
//		 
//        apprepo.deleteById(id);
//    }

	public Map<String, Boolean> deleteapplicant(Long appid) throws ResourceNotFoundException {
	ApplicantModel user = this.apprepo.findById(appid)
	.orElseThrow(() -> new ResourceNotFoundException("applicant not found for this id :: " + appid));
	
	this.apprepo.delete(user);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
	}

}
