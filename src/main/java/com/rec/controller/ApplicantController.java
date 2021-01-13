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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rec.dao.ApplicantDao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicantModel;
import com.rec.model.UserModel;
import com.rec.repository.ApplicantRepository;

@CrossOrigin 
@RestController
@RequestMapping("/applicantc")
public class ApplicantController {
	@Autowired
    ApplicantRepository apprepo;
	
	@Autowired
	ApplicantDao applicantservice;
    
	@GetMapping("/allapplicant")
	public List<ApplicantModel> getAll(){
	return apprepo.findAll();
	}
	
	@GetMapping(path="/allapplicant/{ApplicantId}" , produces="application/json")
	public ResponseEntity<ApplicantModel> getById(@PathVariable(value="ApplicantId") long ApplicantId) throws ResourceNotFoundException {



	return applicantservice.getApplicantById(ApplicantId);
	} 
	
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApplicantModel> createApplicant(@RequestBody ApplicantModel app) {

	ResponseEntity<ApplicantModel> response =null;
	ApplicantModel status = null;
    

	try {
	status =applicantservice.Save(app);
	response= new ResponseEntity<ApplicantModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<ApplicantModel>(status,HttpStatus.BAD_REQUEST);

	}

	return response;
	}
	@PutMapping("/update/{id}")
	public ApplicantModel updateapplicant(@PathVariable(value="id") Long id,@Valid @RequestBody ApplicantModel app) throws ResourceNotFoundException {
	System.out.println(id+" "+app);
	return applicantservice.updateapplicant(id,app);
	}

	@DeleteMapping("/deleteapplicant/{id}")
	public Map<String, Boolean> deleteApplicant(@PathVariable(value = "id") Long appid) throws ResourceNotFoundException{
			return applicantservice.deleteapplicant(appid);
	}
}
