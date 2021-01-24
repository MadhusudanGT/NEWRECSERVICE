package com.rec.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rec.dao.service.RecruiterService;
import com.rec.model.ApplicationEvaluation;
import com.rec.model.Recruiters;
import com.rec.repository.ApplicationREvaluteepository;
import com.rec.repository.RecruiterRepository;

@Service
public class Recruiterdao implements RecruiterService{

	
	@Autowired
	RecruiterRepository repo;
	
	@Autowired
	ApplicationREvaluteepository apprepo;
	@Override
	public ResponseEntity<Object> getAll(){
		
		
		List<Recruiters> res= repo.findAll();
		
		return ResponseEntity.accepted().body(res);
	}
	
	@Override
	 @Transactional
	public ResponseEntity<Object> getRecruiter(long id){
		
		
		
		return null;
	}
	
	@Override
	@Transactional
	public ResponseEntity<Object> saveRecruiter(Recruiters recruiter){
		
		Recruiters newrec=new Recruiters();
		newrec.setFirstName(recruiter.getFirstName());
		newrec.setLastName(recruiter.getLastName());
		newrec.setApplication(recruiter.getApplication());
		
		Recruiters saverec=repo.save(newrec);
//		apprepo.saveAll(recruiter.getApplication());
		 if (repo.findById(saverec.getId()).isPresent()) {
	            return ResponseEntity.accepted().body(saverec);
	        } else
	            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
		  	}
	@Override
	@Transactional
	public ResponseEntity<Object> deleteRecruiter(Long id){
			
		try {
			 if(repo.findById(id)!=null) {
				
				repo.deleteById(id);
				return ResponseEntity.accepted().body("deleted succesfully");
			}
			else {
				return ResponseEntity.accepted().body("no data found");
			}
			}
			catch(Exception e) {
				return ResponseEntity.accepted().body("no data found"+e);
			}
		 
			
	}
	
	@Override
	@Transactional
	public ResponseEntity<Object> updateRecruiter(Recruiters recruiter){
		
		Recruiters newrec=new Recruiters();
		newrec.setFirstName(recruiter.getFirstName());
		newrec.setLastName(recruiter.getLastName());
		newrec.setApplication(recruiter.getApplication());
		
		Recruiters saverec=repo.save(newrec);
//		apprepo.saveAll(recruiter.getApplication());
		 if (repo.findById(saverec.getId()).isPresent()) {
	            return ResponseEntity.accepted().body(saverec);
	        } else
	            return ResponseEntity.unprocessableEntity().body("Failed to update specified Role");
		  	
	}
	
	@Override
	@Transactional
	public ResponseEntity<Object> getByFirstName(String fname) {
		// TODO Auto-generated method stub
		try {
			Object res= repo.findByfirstName(fname);
			 	
			if(res!=null) {
				
				
				return ResponseEntity.accepted().body(res);
			}
			else {
				return ResponseEntity.accepted().body("no data found");
			}
			}
			catch(Exception e) {
				return ResponseEntity.accepted().body("no data found"+e);
			}
	
	 
	}
	

	
}