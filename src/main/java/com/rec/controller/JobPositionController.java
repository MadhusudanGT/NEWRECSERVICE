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

import com.rec.dao.JobPositiondao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobPlatform;
import com.rec.model.JobPosition;
import com.rec.repository.JobPositionRepository;

@CrossOrigin 
@RestController
@RequestMapping("/jpc")
public class JobPositionController {
@Autowired
JobPositiondao positiondao;

@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
public JobPosition createuser(@RequestBody JobPosition position) {
		 	return positiondao.saveposition(position);
	}

 @GetMapping("/getplatform")
    public ResponseEntity<List<JobPosition>> getAllEmployees() {
 
        List<JobPosition> employees =positiondao.getAllplatfrom();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
 
	@PutMapping(path="/update/{id}",consumes = "application/json", produces = "application/json")
	public JobPosition updateuser(@PathVariable(value = "id") Long id,@RequestBody JobPosition emp) throws ResourceNotFoundException {
		positiondao.updateemp(id,emp);
		return emp;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<JobPosition> getUserById(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
			return positiondao.finduserbyid(uid);
	}
	
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
			return positiondao.deleteuser(uid);
	}
}