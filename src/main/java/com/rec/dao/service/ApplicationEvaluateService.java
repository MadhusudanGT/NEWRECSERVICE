package com.rec.dao.service;

import org.springframework.http.ResponseEntity;

import com.rec.model.ApplicationEvaluation;
import com.rec.model.Recruiters;

public interface ApplicationEvaluateService {
 

	ResponseEntity<Object> getAll( );

	ResponseEntity<Object> saveappEvaluate(ApplicationEvaluation recruiter);

	ResponseEntity<Object> deleteByid(Long id);
	
	ResponseEntity<Object> updateByid(ApplicationEvaluation recruiter);

	ResponseEntity<Object> getById(long id);

	 

	
}