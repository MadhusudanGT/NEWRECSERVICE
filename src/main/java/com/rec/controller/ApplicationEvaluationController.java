package com.rec.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.dao.AppliEvaluationDao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicationEvaluation;
import com.rec.model.Recruiters;

@CrossOrigin 
@RestController
@RequestMapping("/aec")
public class ApplicationEvaluationController {
@Autowired
private AppliEvaluationDao dao;

@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
public ApplicationEvaluation createRecuiter(@RequestBody ApplicationEvaluation employee) {
 System.out.print("job json object"+employee);
 ApplicationEvaluation emp = dao.addEvaluation(employee);
	        return emp;
	    
	}

@GetMapping(path="/getall")
public ResponseEntity<List<ApplicationEvaluation>> getAllEvaluation() {
	 
    List<ApplicationEvaluation> employees = dao.getAllEvaluation();
    return new ResponseEntity<>(employees, HttpStatus.OK);
}

@PutMapping(path="/update/{id}",consumes = "application/json", produces = "application/json")
public ApplicationEvaluation updateEvaluation(@PathVariable(value = "id") Long id,@RequestBody ApplicationEvaluation emp) throws ResourceNotFoundException {
	dao.updateEvaluation(id,emp);
	return emp;
}

@GetMapping("/users/{id}")
public ResponseEntity<ApplicationEvaluation> getEvaluationById(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
		return dao.findEvaluationbyid(uid);
}

@DeleteMapping("/users/{id}")
public Map<String, Boolean> deleteEvaluation(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
		return dao.deleteEvaluation(uid);
}
}
