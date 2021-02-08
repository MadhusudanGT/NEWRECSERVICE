package com.rec.dao.service;

import org.springframework.http.ResponseEntity;

import com.rec.model.AnswersModel;


public interface AnswerService {
	

	ResponseEntity<Object> deleteRole(Long id);
	ResponseEntity<Object> updateRole(Long id, AnswersModel model);
}
