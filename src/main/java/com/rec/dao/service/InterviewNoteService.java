package com.rec.dao.service;

import org.springframework.http.ResponseEntity;

import com.rec.model.InterviewNoteModel;

public interface InterviewNoteService {
//	public ResponseEntity<Object> addRole(InterviewNoteModel model);
	public ResponseEntity<Object> deleteRole(Long id);
	public ResponseEntity<Object> updateRole(Long id, InterviewNoteModel model);
}
