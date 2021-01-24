package com.rec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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


import com.rec.dao.JobDao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobModel;
import com.rec.model.JobPlatform;
import com.rec.model.JobPosition;
import com.rec.model.OrganizationModel;
import com.rec.model.UserModel;
import com.rec.repository.JobPlatformRepository;
import com.rec.repository.JobPositionRepository;
import com.rec.repository.JobRepository;
import com.rec.repository.OrganizationRepository;
import com.sun.el.stream.Optional;
import org.springframework.http.ResponseEntity;

@CrossOrigin 
@RestController
@RequestMapping("/jb")
public class JobController {

	@Autowired
	JobDao jobdao;
	
	@Autowired
	JobPlatformRepository platformrepo;
	@Autowired
	JobPositionRepository positionrepo;
	@Autowired
	OrganizationRepository orgrepo;
	@Autowired
	JobRepository jobrepo;
	
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public JobModel createuser(@RequestBody JobModel employee) {
	 System.out.print("job json object"+employee);
		     JobModel emp = jobdao.addEmployee(employee);
		        return emp;
		    
		}
	
	@GetMapping(path="/getall")
	public ResponseEntity<List<JobModel>> getAllEmployees() {
		 
        List<JobModel> employees = jobdao.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
	
	@PutMapping(path="/update/{id}",consumes = "application/json", produces = "application/json")
	public JobModel updateuser(@PathVariable(value = "id") Long id,@RequestBody JobModel emp) throws ResourceNotFoundException {
		jobdao.updateemp(id,emp);
		return emp;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<JobModel> getUserById(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
			return jobdao.finduserbyid(uid);
	}
	
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
			return jobdao.deleteuser(uid);
	}

}