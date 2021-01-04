package com.rec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.dao.Contactdao;
import com.rec.dao.Userdao;
import com.rec.model.ContactModel;
import com.rec.model.UserModel;
import com.rec.repository.ContactRepo;
import com.rec.repository.UserRepository;

@CrossOrigin 
@RestController
@RequestMapping("/usr")
public class UserController {
	
	@Autowired
	 Userdao userservice;
	 
	 
	@GetMapping("/")
	public String get() {
		return "home";
	}
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserModel> createuser(@RequestBody UserModel data) {
		ResponseEntity<UserModel> response =null;
		UserModel status = null;
		 try {
			 status =userservice.Save(data);
			 response= new ResponseEntity<UserModel>(status, HttpStatus.OK);
		 }
		 catch(Exception e) {
			 response = new ResponseEntity<UserModel>(status,HttpStatus.BAD_REQUEST);
		 }
		
		
		
		
		 return  response;
	}

}
