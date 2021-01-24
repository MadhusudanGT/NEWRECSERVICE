package com.rec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rec.dao.Recruiterdao;
import com.rec.model.Recruiters;

@RestController
@CrossOrigin	
@RequestMapping("/recruiter")
public class RecruiterController {
	
	
	@Autowired
	Recruiterdao dao;
	
	
	@GetMapping("")
	public ResponseEntity<Object> get(){
		
		return dao.getAll();
	}
	
	@PostMapping("")
public ResponseEntity<Object> createRecruiter(@RequestBody Recruiters recruiter){
		
		return dao.saveRecruiter(recruiter);
	}
	
	
	@PutMapping("")
public ResponseEntity<Object> deleteRecruiter(@RequestBody Recruiters recruiter){
		
		return dao.updateRecruiter(recruiter);
	}
	
	@DeleteMapping("/{id}")
public ResponseEntity<Object> updateRecruiter( @PathVariable Long id){
		
		return dao.deleteRecruiter(id);
	}
	
	@GetMapping("/fname")
	public ResponseEntity<Object> getbyfname(@RequestParam String fname){
		
		return dao.getByFirstName(fname);
	}
	
	
	

}