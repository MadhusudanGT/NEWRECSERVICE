package com.rec.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.model.UserModel;
import com.rec.repository.UserRepository;

@Service
public class Userdao {
	
	@Autowired
	UserRepository repo;
	
	public UserModel Save(UserModel user) {
		System.out.print("success"+ user);
		return repo.save(user);
	}
	
 
	

}
