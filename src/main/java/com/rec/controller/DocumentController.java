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
import com.rec.dao.DocumentDao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.DocumentModel;
import com.rec.repository.DocumentRepository;

@CrossOrigin 
@RestController
@RequestMapping("/docc")
public class DocumentController {
	@Autowired
	DocumentDao documentservice;

	@Autowired
    DocumentRepository docrepo;
	

	@GetMapping("/alldoc")
	public List<DocumentModel> getAll(){
	return docrepo.findAll();
	}
	
	@GetMapping(path="/alldoc/{DocumentId}" , produces="application/json")
	public ResponseEntity<DocumentModel> getById(@PathVariable(value="DocumentId") long DocumentId) throws ResourceNotFoundException {



	return documentservice.getDocumentById(DocumentId);
	} 
	
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<DocumentModel> createDocument(@RequestBody DocumentModel doc) {

	ResponseEntity<DocumentModel> response =null;
	DocumentModel status = null;
    

	try {
	status = documentservice.Save(doc);
	response= new ResponseEntity<DocumentModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<DocumentModel>(status,HttpStatus.BAD_REQUEST);

		ResponseEntity<DocumentModel> response1 =null;
		DocumentModel status1 = null;
		 try {
			 status1 =documentservice.Save(doc);
			 response1= new ResponseEntity<DocumentModel>(status1, HttpStatus.OK);
		 }
		 catch(Exception e1) {
			 response1 = new ResponseEntity<DocumentModel>(status1,HttpStatus.BAD_REQUEST);
		 }
		
		 return  response1;

	}
	return response;
	}
	
	@PutMapping("/update/{id}")
	public DocumentModel updatedocument(@PathVariable(value="id") Long id,@Valid @RequestBody DocumentModel doc) throws ResourceNotFoundException {
	System.out.println(id+" "+doc);
	return documentservice.updatedocument(id,doc);
	

	}
	
	@DeleteMapping("/deletedoc/{id}")
	public Map<String, Boolean> deleteDocument(@PathVariable(value = "id") Long docid) throws ResourceNotFoundException{
			return documentservice.deletedocument(docid);
	}
}
