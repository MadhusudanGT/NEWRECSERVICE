package com.rec.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicantModel;
import com.rec.model.ApplicationDocumentModel;
import com.rec.model.ApplicationEvaluation;
import com.rec.model.ApplicationModel;
import com.rec.repository.ApplicationRepository;
import com.rec.util.UserValidation;


@Service
public class ApplicationDao {

	@Autowired
	private ApplicationRepository applicationrepo;
	
	@Autowired
	UserValidation uservalidation;
	
	public ApplicationModel Save(ApplicationModel data) {
		return applicationrepo.save(data);
	}

	public ResponseEntity<Object> deleteRole(Long id) {
		if (applicationrepo.findById(id).isPresent()) {
			applicationrepo.deleteById(id);
            if (applicationrepo.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Answer");
            else return ResponseEntity.ok().body("Successfully deleted the specified Answer");
        } else return ResponseEntity.badRequest().body("Cannot find the user specified");
		

	}
	
	@Transactional
	public ResponseEntity<Object> updateRole(Long id, ApplicationModel data){
		
	    if(applicationrepo.findById(id).isPresent()) {
	    	ApplicationModel newUser = applicationrepo.findById(id).get();
           newUser.setAppliedDate(data.getAppliedDate());
           newUser.setEducation(data.getEducation());
           newUser.setExperience(data.getExperience());
           newUser.setOtherInfo(data.getOtherInfo());
           newUser.setJobId(data.getJobId());
           newUser.setApplicantId(data.getApplicantId());
           newUser.setEmailID(data.getEmailID());
           ApplicantModel applicantmodel=data.getApplicantmodel();
           List<ApplicationDocumentModel> appdocumodel=data.getApplicationdocumodel(); 
           newUser.setApplicantmodel(applicantmodel);
           newUser.setApplicationdocumodel(appdocumodel);
            ApplicationModel savedUser = applicationrepo.save(newUser);
            if(applicationrepo.findById(savedUser.getId()).isPresent())
                return  ResponseEntity.accepted().body("Answer updated successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed updating the Answer specified");
        } else return ResponseEntity.unprocessableEntity().body("Cannot find the Answer specified");
	}
//
//	public ResponseEntity<ApplicationModel> findbyid(Long uid) throws ResourceNotFoundException {
//		ApplicationModel user = this.applicationrepo.findById(uid)
//				.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + uid));
//		return ResponseEntity.ok().body(user);
//	}

	public ResponseEntity<String> AcceptUser(Long id) {
		 if(applicationrepo.findById(id).isPresent()) {
		    	ApplicationModel newUser = applicationrepo.findById(id).get();
	        newUser.setStatus("Accepted");
	            ApplicationModel savedUser = applicationrepo.save(newUser);
	            if(applicationrepo.findById(savedUser.getId()).isPresent())
	                return  ResponseEntity.accepted().body("status updated");
	            else return ResponseEntity.unprocessableEntity().body("Failed updating the status");
	        } else return ResponseEntity.unprocessableEntity().body("Cannot find the staus");
	}

	public ResponseEntity<String> RejectUser(Long id) {
		 if(applicationrepo.findById(id).isPresent()) {
		    	ApplicationModel newUser = applicationrepo.findById(id).get();
	        newUser.setStatus("Reject");
	            ApplicationModel savedUser = applicationrepo.save(newUser);
	            if(applicationrepo.findById(savedUser.getId()).isPresent())
	                return  ResponseEntity.accepted().body("status updated");
	            else return ResponseEntity.unprocessableEntity().body("Failed updating the status");
	        } else return ResponseEntity.unprocessableEntity().body("Cannot find the staus");
	}

	public ApplicationModel getByEmailId(String email) {
		if(uservalidation.isregEmailId(email)) {
			System.out.print("valide eamil");
			return applicationrepo.findByEmailId(email);
		}
		return null;
		}
	
}
