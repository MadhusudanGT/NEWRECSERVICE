package com.rec.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rec.dao.service.AnswerService;
import com.rec.model.AnswersModel;

import com.rec.repository.AnswerRepo;

@Service
public class AnswerDao implements AnswerService {
	
	
	@Autowired
	AnswerRepo repo;
	

	public AnswersModel Save(AnswersModel Answer) {
		
		
		return repo.save(Answer);
	}


	
	/** Creating Answer */
//	@Override
//	public ResponseEntity<Object> addAnswer(AnswersModel model) {
//		
//		AnswersModel Answer = new AnswersModel();
//        if (repo.findByRecruiterid(model.getRecruiterid()).isPresent()) {
//            return ResponseEntity.badRequest().body("The ApplicationTest is already Present, Failed to Create new Test");
//        } else {
//        	Answer.setApplicationTest(model.getApplicationTest());
//        	Answer.setRecruiterid(model.getRecruiterid());
//        	Answer.setTotalGrades(model.getTotalGrades());
//        	Answer.setAnswerDetials(model.getAnswerDetials());
//        	Answer.setPass(model.isPass());
//        	
//
//        	AnswersModel savedUser = repo.save(Answer);
//            if (repo.findById(savedUser.getId()).isPresent())
//                return ResponseEntity.ok("User Created Successfully");
//            else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
//        }
//    
//		
//	}

	
	
	/** Deleting an Existing Answer */
	@Override
	public ResponseEntity<Object> deleteRole(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
            if (repo.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Answer");
            else return ResponseEntity.ok().body("Successfully deleted the specified Answer");
        } else return ResponseEntity.badRequest().body("Cannot find the user specified");
		
	}

	/** Update an Existing Answer */
	@Transactional
	@Override
	public ResponseEntity<Object> updateRole(Long id, AnswersModel model) {
		
	    if(repo.findById(id).isPresent()) {
	    	AnswersModel newUser = repo.findById(id).get();
            newUser.setApplicationTest(model.getApplicationTest());
            newUser.setRecruiterid(model.getRecruiterid());
            newUser.setTotalGrades(model.getTotalGrades());
            newUser.setAnswerDetials(model.getAnswerDetials());
            newUser.setPass(model.isPass());
            AnswersModel savedUser = repo.save(newUser);
            if(repo.findById(savedUser.getId()).isPresent())
                return  ResponseEntity.accepted().body("Answer updated successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed updating the Answer specified");
        } else return ResponseEntity.unprocessableEntity().body("Cannot find the Answer specified");
	}


	 
	  


	
}