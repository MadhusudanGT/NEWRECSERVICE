package com.rec.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobModel;
import com.rec.model.JobPlatform;
import com.rec.repository.JobPlatformRepository;
import com.rec.repository.JobPositionRepository;
@Service
public class JobPlatformdao {
@Autowired
JobPlatformRepository platformrepo;

	public List<JobPlatform> getAllplatfrom() {
		
		return platformrepo.findAll();
	}

	
	public Map<String, Boolean> deleteuser(Long uid) throws ResourceNotFoundException {
		JobPlatform user = this.platformrepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + uid));

		this.platformrepo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	public ResponseEntity<JobPlatform> finduserbyid(Long uid) throws com.rec.exception.ResourceNotFoundException {
		JobPlatform user = this.platformrepo.findById(uid)
				.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + uid));
		return ResponseEntity.ok().body(user);
	}


	public JobPlatform updateemp(Long id, JobPlatform emp)throws com.rec.exception.ResourceNotFoundException {
		JobPlatform user = this.platformrepo.findById(id)
				.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + id));
		user.setPlatformName(emp.getPlatformName());
		user.setPlatformDescription(emp.getPlatformDescription());
		user.setId(user.getId());
		return platformrepo.save(user);
	}


	public JobPlatform saveplatform(JobPlatform platform) {
		System.out.print(platform);
		JobPlatform result=platformrepo.save(platform);
		return result;
	}

}