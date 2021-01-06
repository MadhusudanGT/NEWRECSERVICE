package com.rec.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.model.ContactModel;
import com.rec.model.UserModel;
import com.rec.repository.ContactRepo;

@Service
public class Contactdao {
	
	@Autowired
	ContactRepo repo;
	
	public ContactModel Save(ContactModel contact) {
		
		return repo.save(contact);
	}
   
	public Optional<ContactModel> findById(long id) {
		System.out.print("sucessfully found");
		return repo.findById(id);
	}
	
}
