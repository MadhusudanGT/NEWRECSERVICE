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
import com.rec.dao.ApplicationDocumentDao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicationDocumentModel;
import com.rec.repository.ApplicationDocumentRepository;

@CrossOrigin 
@RestController
@RequestMapping("/appdocc")
public class ApplicationDocumentController {
	@Autowired
	ApplicationDocumentDao applicationdocumentservice;

	@Autowired
    ApplicationDocumentRepository appdocrepo;
	

	@GetMapping("/allappdoc")
	public List<ApplicationDocumentModel> getAll(){
	return appdocrepo.findAll();
	}
	
	@GetMapping(path="/allappdoc/{ApplicationDocumentId}" , produces="application/json")
	public ResponseEntity<ApplicationDocumentModel> getById(@PathVariable(value="ApplicationDocumentId") long ApplicationDocumentId) throws ResourceNotFoundException {



	return applicationdocumentservice.getApplicationDocumentById(ApplicationDocumentId);
	} 
	
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApplicationDocumentModel> createApplicationDocument(@RequestBody ApplicationDocumentModel appdoc) {

	ResponseEntity<ApplicationDocumentModel> response =null;
	ApplicationDocumentModel status = null;
  
	try {
	status =applicationdocumentservice.Save(appdoc);
	response= new ResponseEntity<ApplicationDocumentModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<ApplicationDocumentModel>(status,HttpStatus.BAD_REQUEST);

	}
	return response;
	}
	
	@PutMapping("/update/{id}")
	public ApplicationDocumentModel updateApplicationDocument(@PathVariable(value="id") Long id,@Valid @RequestBody ApplicationDocumentModel appdoc) throws ResourceNotFoundException {
	System.out.println(id+" "+appdoc);
	return applicationdocumentservice.updateapplicationdocument(id,appdoc);
	

	}
	@DeleteMapping("/deleteappdoc/{id}")
	public Map<String, Boolean> deleteApplication(@PathVariable(value = "id") Long appdocid) throws ResourceNotFoundException{
			return applicationdocumentservice.deleteapplicationdocument(appdocid);
	}
}
