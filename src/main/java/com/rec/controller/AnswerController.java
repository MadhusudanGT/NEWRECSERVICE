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


import com.rec.dao.AnswerDao;

import com.rec.model.AnswersModel;

import com.rec.repository.AnswerRepo;


@CrossOrigin
@RestController
@RequestMapping("/Answers")

public class AnswerController {
	@Autowired
	AnswerDao Answerservice;

	@Autowired
	AnswerRepo Answerrepo;



	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<AnswersModel> createuser(@RequestBody AnswersModel data) {

	ResponseEntity<AnswersModel> response =null;
	AnswersModel status = null;


	try {
	status =Answerservice.Save(data);
	response= new ResponseEntity<AnswersModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<AnswersModel>(status,HttpStatus.BAD_REQUEST);

		ResponseEntity<AnswersModel> response1 =null;
		AnswersModel status1 = null;
		 try {
			 status1 =Answerservice.Save(data);
			 response1= new ResponseEntity<AnswersModel>(status1, HttpStatus.OK);
		 }
		 catch(Exception e1) {
			 response1 = new ResponseEntity<AnswersModel>(status1,HttpStatus.BAD_REQUEST);
		 }
		
		 return  response1;

	}


	return response;
	}
	
//	 @PostMapping("/create")
//	    public ResponseEntity<Object> createAnswer(@RequestBody AnswersModel Model) {
//	        return  Answerservice.addAnswer(Model);
//	    }
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
	        return Answerservice.deleteRole(id);
	    }
	    @GetMapping("/details/{id}")
	    public AnswersModel getAnswers(@PathVariable Long id) {
	        if(Answerrepo.findById(id).isPresent())
	            return Answerrepo.findById(id).get();
	        else return null;
	    }
	    @GetMapping("/all")
	    public List<AnswersModel> getRoles() {
	        return Answerrepo.findAll();
	    }
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Object> updateRole(@PathVariable Long id, @RequestBody AnswersModel role) {
	        return Answerservice.updateRole(id, role);
	    }
	
}