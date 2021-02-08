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


import com.rec.dao.InterviewDao;
import com.rec.dao.TestDao;
import com.rec.model.InterviewModel;
import com.rec.model.TestModel;
import com.rec.repository.InterviewRepo;
import com.rec.repository.TestRepo;



@CrossOrigin
@RestController
@RequestMapping("/Interview")
public class InterviewController {
	@Autowired
	InterviewDao Interviewservice;

	@Autowired
	InterviewRepo Interviewrepo;



	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<InterviewModel> createuser(@RequestBody InterviewModel data) {

	ResponseEntity<InterviewModel> response =null;
	InterviewModel status = null;


	try {
	status =Interviewservice.Save(data);
	response= new ResponseEntity<InterviewModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<InterviewModel>(status,HttpStatus.BAD_REQUEST);

		ResponseEntity<InterviewModel> response1 =null;
		InterviewModel status1 = null;
		 try {
			 status1 =Interviewservice.Save(data);
			 response1= new ResponseEntity<InterviewModel>(status1, HttpStatus.OK);
		 }
		 catch(Exception e1) {
			 response1 = new ResponseEntity<InterviewModel>(status1,HttpStatus.BAD_REQUEST);
		 }
		
		 return  response1;

	}


	return response;
	}
	
//	    @PostMapping("/create")
//	    public ResponseEntity<Object> createRole(@RequestBody InterviewModel Model) {
//	        return  Interviewservice.addInterview(Model);
//	    }
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
	        return Interviewservice.deleteInterview(id);
	    }
	    @GetMapping("/details/{id}")
	    public InterviewModel getRole(@PathVariable Long id) {
	        if(Interviewrepo.findById(id).isPresent())
	            return Interviewrepo.findById(id).get();
	        else return null;
	    }
	    @GetMapping("/all")
	    public List<InterviewModel> getInterviews() {
	        return Interviewrepo.findAll();
	    }
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Object> updateInterview(@PathVariable Long id, @RequestBody InterviewModel model) {
	        return Interviewservice.updateInterview(id, model);
	    }
}
