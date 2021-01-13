package com.rec.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.rec.dao.JobDao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicantModel;
import com.rec.model.ApplicationModel;
import com.rec.model.JobModel;
import com.rec.repository.JobRepository;
@CrossOrigin 
@RestController
@RequestMapping("/jobc")
public class JobController {
	@Autowired
    JobRepository jobrepo;
	
	@Autowired
	JobDao jobservice;
    

	@GetMapping("/alljob")
	public List<JobModel> getAll(){
	return jobrepo.findAll();
	}
	
	@GetMapping(path="/alljob/{JobId}" , produces="application/json")
	public ResponseEntity<JobModel> getById(@PathVariable(value="JobId") long JobId) throws ResourceNotFoundException {



	return jobservice.getJobById(JobId);
	} 
	
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<JobModel> createJob(@RequestBody JobModel job) {

	ResponseEntity<JobModel> response =null;
	JobModel status = null;
    

	try {
	status =jobservice.Save(job);
	response= new ResponseEntity<JobModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<JobModel>(status,HttpStatus.BAD_REQUEST);

	}

	return response;
	}
	
	@PutMapping("/update/{id}")
	public JobModel updateJob(@PathVariable(value="id") Long id,@Valid @RequestBody JobModel job) throws ResourceNotFoundException {
	System.out.println(id+" "+job);
	return jobservice.updatejob(id,job);
	

	}
	@DeleteMapping("/deletejob/{id}")
	public Map<String, Boolean> deleteJob(@PathVariable(value = "id") Long jobid) throws ResourceNotFoundException{
			return jobservice.deletejob(jobid);
	}
}
