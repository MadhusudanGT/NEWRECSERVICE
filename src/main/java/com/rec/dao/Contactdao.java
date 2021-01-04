package com.rec.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.model.ContactModel;
import com.rec.repository.ContactRepo;

@Service
public class Contactdao {
	
	@Autowired
	ContactRepo repo;
	
	public ContactModel Save(ContactModel contact) {
		
		return repo.save(contact);
	}

}
