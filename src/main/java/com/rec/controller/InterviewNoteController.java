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


import com.rec.dao.InterviewNoteDao;

import com.rec.model.InterviewNoteModel;

import com.rec.repository.InterviewNoteRepo;




@CrossOrigin
@RestController
@RequestMapping("/InterviewNote")
public class InterviewNoteController {
	@Autowired
	InterviewNoteDao InterviewNoteservice;

	@Autowired
	InterviewNoteRepo InterviewNoterepo;



	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<InterviewNoteModel> createuser(@RequestBody InterviewNoteModel data) {

	ResponseEntity<InterviewNoteModel> response =null;
	InterviewNoteModel status = null;


	try {
	status =InterviewNoteservice.Save(data);
	response= new ResponseEntity<InterviewNoteModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<InterviewNoteModel>(status,HttpStatus.BAD_REQUEST);

		ResponseEntity<InterviewNoteModel> response1 =null;
		InterviewNoteModel status1 = null;
		 try {
			 status1 =InterviewNoteservice.Save(data);
			 response1= new ResponseEntity<InterviewNoteModel>(status1, HttpStatus.OK);
		 }
		 catch(Exception e1) {
			 response1 = new ResponseEntity<InterviewNoteModel>(status1,HttpStatus.BAD_REQUEST);
		 }
		
		 return  response1;

	}


	return response;
	}
	
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
	        return InterviewNoteservice.deleteRole(id);
	    }
	    @GetMapping("/details/{id}")
	    public InterviewNoteModel getInterviewNote(@PathVariable Long id) {
	        if(InterviewNoterepo.findById(id).isPresent())
	            return InterviewNoterepo.findById(id).get();
	        else return null;
	    }
	    @GetMapping("/all")
	    public List<InterviewNoteModel> getInterviewNote() {
	        return InterviewNoterepo.findAll();
	    }
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Object> updateRole(@PathVariable Long id, @RequestBody InterviewNoteModel model) {
	        return InterviewNoteservice.updateRole(id, model);
	    }
}
