package com.rec.dao.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.Recruiters;
import com.rec.model.RoleModel;

public interface RecruiterService {

	
	ResponseEntity<Object> getAll();

	ResponseEntity<Object> getRecruiter(long id);

	ResponseEntity<Object> saveRecruiter(Recruiters recruiter);

	ResponseEntity<Object> deleteRecruiter(Long id);
	
	ResponseEntity<Object> updateRecruiter(Recruiters recruiter);

	ResponseEntity<Object> getByFirstName(String fname);

	
	
}