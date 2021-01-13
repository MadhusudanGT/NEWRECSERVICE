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
import com.rec.dao.ApplicationDao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicantModel;
import com.rec.model.ApplicationModel;
import com.rec.repository.ApplicationRepository;

@CrossOrigin 
@RestController
@RequestMapping("/appc")
public class ApplicationController {
	@Autowired
	ApplicationDao applicationservice;

	@Autowired
    ApplicationRepository apprepo;
	
	@GetMapping("/allapplication")
	public List<ApplicationModel> getAll(){
	return apprepo.findAll();
	}
	
	@GetMapping(path="/allapplication/{ApplicationId}" , produces="application/json")
	public ResponseEntity<ApplicationModel> getById(@PathVariable(value="ApplicationId") long ApplicationId) throws ResourceNotFoundException {

	return applicationservice.getApplicationById(ApplicationId);
	} 
	
	
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApplicationModel> createApplication(@RequestBody ApplicationModel app) {

	ResponseEntity<ApplicationModel> response =null;
	ApplicationModel status = null;
    

	try {
	status =applicationservice.Save(app);
	response= new ResponseEntity<ApplicationModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<ApplicationModel>(status,HttpStatus.BAD_REQUEST);

	}
	return response;
	}
	
	@PutMapping("/update/{id}")
	public ApplicationModel updateapplication(@PathVariable(value="id") Long id,@Valid @RequestBody ApplicationModel app) throws ResourceNotFoundException {
	System.out.println(id+" "+app);
	return applicationservice.updateapplication(id,app);
	

	}
	@DeleteMapping("/deleteapplication/{id}")
	public Map<String, Boolean> deleteApplication(@PathVariable(value = "id") Long appid) throws ResourceNotFoundException{
			return applicationservice.deleteapplication(appid);
	}
}
