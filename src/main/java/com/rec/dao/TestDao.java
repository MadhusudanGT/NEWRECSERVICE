package com.rec.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.rec.dao.service.TestService;
import com.rec.model.TestModel;
import com.rec.model.UserModel;
import com.rec.repository.TestRepo;



@Service
public class TestDao implements TestService  {
	@Autowired
	TestRepo repo;
	

	

	@Override
	public ResponseEntity<Object> createUser(TestModel model) {
		TestModel test = new TestModel();
		        if (repo.findById(model.getId()).isPresent()) {
		            return ResponseEntity.badRequest().body("The code is already Present, Failed to Create new Test");
		        } else {
		        	test.setCode(model.getCode());
		        	test.setDuration(model.getDuration());
		        	test.setMaxscore(model.getMaxscore());
		        	test.setApplicationtestModel(model.getApplicationtestModel());
		        	

		        	TestModel savedUser = repo.save(test);
		            if (repo.findById(savedUser.getId()).isPresent())
		                return ResponseEntity.ok("User Created Successfully");
		            else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
		        }
		    }
	}

	

