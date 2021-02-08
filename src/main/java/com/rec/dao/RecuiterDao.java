package com.rec.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicationEvaluation;
import com.rec.model.JobModel;
import com.rec.model.JobPosition;
import com.rec.model.Recruiters;
import com.rec.repository.RecuiterRepository;

@Service
public class RecuiterDao {
	
	@Autowired 
	private RecuiterRepository recuiterrepo;

	public Recruiters addRecuiter(Recruiters employee) {
		return recuiterrepo.save(employee);
	}

	public List<Recruiters> getAllRecuiter() {
		 return recuiterrepo.findAll();
	}

	public Recruiters updateRecuiter(Long id, Recruiters emp) 
		throws ResourceNotFoundException {
		 try {	     
			 Recruiters jpupdate = this.recuiterrepo.save(emp);
	 			return jpupdate;
	    }
	  
	catch(Exception e) {
		System.out.print("Exception found");
	}
	return null;
		
	}

	public Map<String, Boolean> deleteRecuiter(Long uid) throws ResourceNotFoundException {
		Recruiters user = this.recuiterrepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + uid));

		this.recuiterrepo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	public ResponseEntity<Recruiters> findRecuiterbyid(Long uid) throws ResourceNotFoundException {
		Recruiters user = this.recuiterrepo.findById(uid)
				.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + uid));
		return ResponseEntity.ok().body(user);
	}

}
