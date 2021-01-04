package com.rec.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public UserModel createuser(@RequestBody UserModel data) {
		
		System.out.print("success"+ data );
	 
		 return userservice.Save(data);
	}

}
