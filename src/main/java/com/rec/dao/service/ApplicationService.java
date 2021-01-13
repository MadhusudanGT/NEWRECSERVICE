package com.rec.dao.service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicationModel;

public interface ApplicationService {
	ApplicationModel updateapplication(Long id,ApplicationModel data) throws ResourceNotFoundException;
}
