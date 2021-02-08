package com.rec.controller;

import java.util.List;

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

import com.rec.dao.ApplicationTestDao;
import com.rec.model.AnswersModel;
import com.rec.model.ApplicationTestModel;

import com.rec.repository.ApplicationTestRepo;


@CrossOrigin
@RestController
@RequestMapping("/Applicationtest")
public class ApplicationTestController {
	@Autowired
	ApplicationTestDao Applicationtestservice;

	@Autowired
	ApplicationTestRepo testrepo;


	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApplicationTestModel> createuser(@RequestBody ApplicationTestModel data) {

	ResponseEntity<ApplicationTestModel> response =null;
	ApplicationTestModel status = null;

	try {
	status =Applicationtestservice.Save(data);
	response= new ResponseEntity<ApplicationTestModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<ApplicationTestModel>(status,HttpStatus.BAD_REQUEST);

		ResponseEntity<ApplicationTestModel> response1 =null;
		ApplicationTestModel status1 = null;
		 try {
			 status1 =Applicationtestservice.Save(data);
			 response1= new ResponseEntity<ApplicationTestModel>(status1, HttpStatus.OK);
		 }
		 catch(Exception e1) {
			 response1 = new ResponseEntity<ApplicationTestModel>(status1,HttpStatus.BAD_REQUEST);
		 }
		
		 return  response1;

	}


	return response;
}

	 
	
	  @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
	        return Applicationtestservice.deleteRole(id);
	    }
	    @GetMapping("/details/{id}")
	    public ApplicationTestModel getAnswers(@PathVariable Long id) {
	        if(testrepo.findById(id).isPresent())
	            return testrepo.findById(id).get();
	        else return null;
	    }
	    @GetMapping("/all")
	    public List<ApplicationTestModel> getRoles() {
	        return testrepo.findAll();
	    }
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Object> updateRole(@PathVariable Long id, @RequestBody ApplicationTestModel role) {
	        return Applicationtestservice.updateRole(id, role);
	    }
}

