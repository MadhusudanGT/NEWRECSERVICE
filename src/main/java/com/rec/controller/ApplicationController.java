package com.rec.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.rec.model.ApplicationEvaluation;
import com.rec.model.ApplicationModel;
import com.rec.model.RegistrationModel;
import com.rec.repository.ApplicationRepository;


@CrossOrigin
@RestController
@RequestMapping("/appc")
public class ApplicationController {
@Autowired
private ApplicationDao applicationdao;

@Autowired
private ApplicationRepository applicationrepo;

@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
public ResponseEntity<ApplicationModel> createuser(@RequestBody ApplicationModel data) {

ResponseEntity<ApplicationModel> response =null;
ApplicationModel status = null;


try {
status =applicationdao.Save(data);
response= new ResponseEntity<ApplicationModel>(status, HttpStatus.OK);
}
catch(Exception e) {
response = new ResponseEntity<ApplicationModel>(status,HttpStatus.BAD_REQUEST);

	ResponseEntity<ApplicationModel> response1 =null;
	ApplicationModel status1 = null;
	 try {
		 status1 =applicationdao.Save(data);
		 response1= new ResponseEntity<ApplicationModel>(status1, HttpStatus.OK);
	 }
	 catch(Exception e1) {
		 response1 = new ResponseEntity<ApplicationModel>(status1,HttpStatus.BAD_REQUEST);
	 }
	
	 return  response1;

}
return response;
}


@DeleteMapping("/deleteapplication/{id}")
public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
    return applicationdao.deleteRole(id);
}


@GetMapping("/allapplication/{ApplicationId}")
public ApplicationModel getEvaluationById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
	if(applicationrepo.findById(id).isPresent())
	    return applicationrepo.findById(id).get();
	else return null;
}
@GetMapping("/allapplication")
public List<ApplicationModel> getRoles() {
    return applicationrepo.findAll();
}
@PutMapping("/update/{id}")
public ResponseEntity<Object> updateRole(@PathVariable Long id, @RequestBody ApplicationModel role) {
    return applicationdao.updateRole(id, role);
}


@GetMapping("/accept/{id}")
	public ResponseEntity<String> AcceptApplication(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		return this.applicationdao.AcceptUser(id);
	}

@GetMapping("/reject/{id}")
public ResponseEntity<String> RejectApplication(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
	return this.applicationdao.RejectUser(id);
}

@GetMapping(path="/findByEmail/{email}" , produces="application/json")
public ApplicationModel getByEmailId(@PathVariable(value="email") String email) throws ResourceNotFoundException {
return applicationdao.getByEmailId(email);
}
}
