package com.rec.dao.service;

import org.springframework.http.ResponseEntity;

import com.rec.model.AnswersModel;
import com.rec.model.ApplicationTestModel;

public interface ApplicationTestservice {
	ResponseEntity<Object> deleteRole(Long id);
	
	ResponseEntity<Object> updateRole(Long id, ApplicationTestModel model);
}