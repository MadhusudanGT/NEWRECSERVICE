package com.rec.controller;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.dao.Contactdao;
import com.rec.model.ContactModel;
import com.rec.model.UserModel;
import com.rec.repository.UserRepository;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	 @Autowired
	 Contactdao contactservice;
	 @Autowired 
	 UserRepository usr;
	 
	 @PostMapping("/{userId}")
	 public  ResponseEntity<ContactModel> createcontact( @PathVariable (value = "userId") Long userid,@RequestBody ContactModel contact) {
		
		 
		 ResponseEntity<ContactModel> response =null;
			ContactModel status = null;
			 try {
				 status =contactservice.Save(contact,userid);
				 response= new ResponseEntity<ContactModel>(status, HttpStatus.OK);
			 }
			 catch(Exception e) {
				 response = new ResponseEntity<ContactModel>(status,HttpStatus.BAD_REQUEST);
			 }
			
			
			
			
			 return  response;

		 
		 
		 
		
	 }

}