package com.rec.dao.service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobModel;

public interface JobService {
	JobModel updatejob(Long id,JobModel job) throws ResourceNotFoundException;
}
