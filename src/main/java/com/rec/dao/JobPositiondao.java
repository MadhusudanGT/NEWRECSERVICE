package com.rec.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobPlatform;
import com.rec.model.JobPosition;
import com.rec.repository.JobPositionRepository;
@Service
public class JobPositiondao {
@Autowired
JobPositionRepository positionrepo;

public List<JobPosition> getAllplatfrom() {
		
		return positionrepo.findAll();
	}

	
	public Map<String, Boolean> deleteuser(Long uid) throws ResourceNotFoundException {
		JobPosition user = this.positionrepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + uid));

		this.positionrepo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	public ResponseEntity<JobPosition> finduserbyid(Long uid) throws com.rec.exception.ResourceNotFoundException {
		JobPosition user = this.positionrepo.findById(uid)
				.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + uid));
		return ResponseEntity.ok().body(user);
	}

	public JobPosition saveposition(JobPosition platform) {
		System.out.print(platform);
		JobPosition result=positionrepo.save(platform);
		return result;
	}


	public JobPosition updateemp(Long id, JobPosition emp) throws com.rec.exception.ResourceNotFoundException {
		JobPosition user = this.positionrepo.findById(id)
				.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + id));

		user.setName(emp.getName());
		user.setDescription(emp.getDescription());
		user.setId(user.getId());
		user.setJobCategory(emp.getJobCategory());
		user.setJobmodel(emp.getJobmodel());
		return positionrepo.save(user);
		
	}


	
}