package com.rec.controller;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
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
	 public <U> ContactModel createcontact( @PathVariable (value = "userId") Long userid,@RequestBody ContactModel contact) {
		 System.out.println("uid"+userid);
		 
		 
		 usr.findById(userid).map((Function<? super UserModel, ? extends U>) user ->{
			contact.setUserId(user);
			contactservice.Save(contact);
			return (U) contact;
			
		}) ;
		 
		return contact; 
	 }

}
