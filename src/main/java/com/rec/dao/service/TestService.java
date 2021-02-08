package com.rec.dao.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;


import com.rec.exception.ResourceNotFoundException;
import com.rec.model.TestModel;


public interface TestService {
	
	ResponseEntity<Object> createUser(TestModel model);
	
}
