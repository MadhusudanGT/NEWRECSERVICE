package com.rec.dao.service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicationDocumentModel;

public interface ApplicationDocumentService {
	ApplicationDocumentModel updateapplicationdocument(Long id,ApplicationDocumentModel data) throws ResourceNotFoundException;
}
