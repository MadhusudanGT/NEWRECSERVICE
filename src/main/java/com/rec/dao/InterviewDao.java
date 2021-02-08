package com.rec.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.rec.dao.service.InterviewService;
import com.rec.model.ApplicationTestModel;
import com.rec.model.InterviewModel;

import com.rec.repository.InterviewRepo;

@Service
public class InterviewDao implements InterviewService {
	@Autowired
	InterviewRepo repo;
	

	public InterviewModel Save(InterviewModel Interview) {
		
		
		return repo.save(Interview);
	}




	@Override
	public ResponseEntity<Object> deleteInterview(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
            if (repo.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Application test");
            else return ResponseEntity.ok().body("Successfully deleted the Application test");
        } else return ResponseEntity.badRequest().body("Cannot find the Application test specified");
	}


	@Override
	public ResponseEntity<Object> updateInterview(Long id, InterviewModel model) {
		 if(repo.findById(id).isPresent()) {
			 InterviewModel newUser = repo.findById(id).get();
	            newUser.setId(model.getId());
	            newUser.setApplicationId(model.getApplicationId());
	            newUser.setStartTime(model.getStartTime());
	            newUser.setEndTime(model.getEndTime()); 
	            
	            InterviewModel savedUser = repo.save(newUser);
	            if(repo.findById(savedUser.getId()).isPresent())
	                return  ResponseEntity.accepted().body("ApplicationTest updated successfully");
	            else return ResponseEntity.unprocessableEntity().body("Failed updating the Application");
	        } else return ResponseEntity.unprocessableEntity().body("Cannot find the Application specified");
	}



	
}
