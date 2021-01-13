package com.rec.dao.service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicantModel;

public interface ApplicantService {
	ApplicantModel updateapplicant(Long id,ApplicantModel data) throws ResourceNotFoundException;
}
