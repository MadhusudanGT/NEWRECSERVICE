package com.rec.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.dao.service.InterviewNoteService;
import com.rec.model.ApplicationTestModel;
import com.rec.model.InterviewNoteModel;

import com.rec.repository.InterviewNoteRepo;

@Service
public class InterviewNoteDao implements InterviewNoteService {
	@Autowired
	InterviewNoteRepo repo;
	

	public InterviewNoteModel Save(InterviewNoteModel InterviewNote) {
		
		
		return repo.save(InterviewNote);
	}


	


	@Override
	public ResponseEntity<Object> deleteRole(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
            if (repo.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Application test");
            else return ResponseEntity.ok().body("Successfully deleted the Application test");
        } else return ResponseEntity.badRequest().body("Cannot find the Application test specified");
	}


	@Override
	public ResponseEntity<Object> updateRole(Long id, InterviewNoteModel model) {
		 if(repo.findById(id).isPresent()) {
			 InterviewNoteModel newUser = repo.findById(id).get();
	           
	            newUser.setNotes(model.getNotes());
	            newUser.setInterviewId(model.getInterviewId());
	            newUser.setRecruitersId(model.getRecruitersId()); 
	            newUser.setPass(model.isPass());
	            InterviewNoteModel savedUser = repo.save(newUser);
	            if(repo.findById(savedUser.getId()).isPresent())
	                return  ResponseEntity.accepted().body("ApplicationTest updated successfully");
	            else return ResponseEntity.unprocessableEntity().body("Failed updating the Application");
	        } else return ResponseEntity.unprocessableEntity().body("Cannot find the Application specified");
	}


}
