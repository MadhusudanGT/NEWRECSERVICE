package com.rec.dao.service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.DocumentModel;

public interface DocumentService {
	DocumentModel updatedocument(Long id,DocumentModel doc) throws ResourceNotFoundException;
}
