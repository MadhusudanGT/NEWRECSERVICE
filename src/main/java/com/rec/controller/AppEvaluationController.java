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

import com.rec.dao.AppEvaluatedao;
import com.rec.model.ApplicationEvaluation;
import com.rec.model.Recruiters;
import com.rec.repository.ApplicationREvaluteepository;

@RestController
@CrossOrigin	
@RequestMapping("/evaluate")
public class AppEvaluationController {
	
	@Autowired
	ApplicationREvaluteepository apprepo;
	
	@Autowired
	AppEvaluatedao dao;
	
	@GetMapping("")
	public ResponseEntity<Object> getAll(){
		
		return dao.getAll();
	}
	
	
@PostMapping("/create")
public ResponseEntity<Object> createRecruiter(@RequestBody ApplicationEvaluation recruiter){
		
		return dao.saveappEvaluate(recruiter);
	}
	
	
	@DeleteMapping("/{id}")
public ResponseEntity<Object> createRecruiter(@PathVariable Long id){
		
		return dao.deleteByid(id);
	}
	
	@PutMapping("/update")
public ResponseEntity<Object> updateRecruiter(@RequestBody ApplicationEvaluation app){
		
		return dao.updateByid(app);
	}
	
	
	 
	
	 
	
	

}