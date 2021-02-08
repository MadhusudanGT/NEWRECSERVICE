package com.rec.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicationEvaluation;
import com.rec.model.Recruiters;
import com.rec.repository.ApplicationEvaluationRepository;
@Service
public class AppliEvaluationDao {
	@Autowired ApplicationEvaluationRepository repo;

	public ApplicationEvaluation addEvaluation(ApplicationEvaluation employee) {
		return repo.save(employee);
	}

	public List<ApplicationEvaluation> getAllEvaluation() {
		return repo.findAll();
	}

	public ApplicationEvaluation updateEvaluation(Long id, ApplicationEvaluation emp)	throws ResourceNotFoundException {
//		ApplicationEvaluation aem = repo.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));
//		         System.out.print("ApplicationEvaluation"+aem);
//		  try {	    
//			  if(true) {
//				  aem.setApplicaitionId(emp.getApplicaitionId());
//				  aem.setHired(emp.getHired());
//				  aem.setId(id);
//				  aem.setNotes(emp.getNotes());
//				  Recruiters recruiters=emp.getRecruiters();
//				  aem.setRecruiters(recruiters);
	    		  ApplicationEvaluation jpupdate = this.repo.save(emp);
		 			return jpupdate;
//			  }
//			  else {
//				  System.out.print("Insert data properly");
//			  }
//		
//         }
//       
//    catch(Exception e) {
//    	System.out.print("Exception found");
//    }
//    return null;
	}

	public ResponseEntity<ApplicationEvaluation> findEvaluationbyid(Long uid) throws ResourceNotFoundException {
		ApplicationEvaluation user = this.repo.findById(uid)
				.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + uid));
		return ResponseEntity.ok().body(user);
	}

	public Map<String, Boolean> deleteEvaluation(Long uid) throws ResourceNotFoundException {
		ApplicationEvaluation user = this.repo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + uid));

		this.repo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
}
