package com.rec.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
=======
>>>>>>> cbaf408b641e164eef2ffc271e4a1e97d7188205
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.exception.ResourceNotFoundException;
//import com.mycart.model.User;
//import com.mycart.model.User;
//import com.mycart.model.User;
import com.rec.dao.Contactdao;
import com.rec.dao.Userdao;
import com.rec.dao.service.UserService;
import com.rec.model.ContactModel;
import com.rec.model.UserModel;
import com.rec.repository.ContactRepo;
import com.rec.repository.UserRepository;
//import com.rec.util.UserValidation;


@CrossOrigin 
@RestController
@Validated
@RequestMapping("/usr")
public class UserController {
	
	@Autowired
	Userdao userservice;
	@Autowired
	UserRepository repo;
//	@Autowired
//	UserValidation userval;
	@GetMapping("/")
	public String get() {
		return "home";
	}
	
	@PutMapping("/update/{id}")
	public UserModel updateuser(@PathVariable(value="id") Long id,@Valid @RequestBody UserModel data) throws ResourceNotFoundException {
	System.out.println(id+" "+data);
//	userval.validate(UniqueConstraint., bindingResult);
	return userservice.updateuser(id,data);

	}
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserModel> createuser(@RequestBody UserModel data) {
<<<<<<< HEAD
	ResponseEntity<UserModel> response =null;
	UserModel status = null;
    

	try {
	status =userservice.Save(data);
	response= new ResponseEntity<UserModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<UserModel>(status,HttpStatus.BAD_REQUEST);
=======
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
>>>>>>> cbaf408b641e164eef2ffc271e4a1e97d7188205
	}




	return response;
	}


	@GetMapping(path="/user/{UserId}" , produces="application/json")
	public ResponseEntity<UserModel> getById(@PathVariable(value="UserId") long UserId) throws ResourceNotFoundException {



	return userservice.getUserById(UserId);
	} 
	
	@GetMapping("/users")
	public List<UserModel> getAll(){
	return repo.findAll();
	}

//	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
//	public UserModel createuser(@Valid @RequestBody UserModel data) {
//
//	System.out.print("success"+ data );
//
//	return userservice.addUser(data);
//	}
	
	}
