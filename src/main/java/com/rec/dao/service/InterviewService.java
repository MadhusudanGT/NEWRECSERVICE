package com.rec.dao.service;

import org.springframework.http.ResponseEntity;

import com.rec.model.InterviewModel;

public interface InterviewService {

	ResponseEntity<Object> deleteInterview(Long id);
	ResponseEntity<Object> updateInterview(Long id, InterviewModel role);
}
