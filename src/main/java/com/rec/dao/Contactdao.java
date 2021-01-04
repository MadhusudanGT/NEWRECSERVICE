package com.rec.dao;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.model.ContactModel;
import com.rec.model.UserModel;
import com.rec.repository.ContactRepo;
import com.rec.repository.UserRepository;

@Service
public class Contactdao {
	
	@Autowired
	ContactRepo repo;
	 @Autowired
	 Contactdao contactservice;
	 @Autowired 
	 UserRepository usr;
	
	public <U> ContactModel Save(ContactModel contact, Long userid) {
		
		 usr.findById(userid).map((Function<? super UserModel, ? extends U>) user ->{
				contact.setUserId(user);
				return (U) repo.save(contact);
				
			}) ;
			 
			return contact; 
		
	}

}