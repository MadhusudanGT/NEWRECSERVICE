package com.rec.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.dao.JobPlatformdao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobModel;
import com.rec.model.JobPlatform;
import com.rec.repository.JobPlatformRepository;


@CrossOrigin 
@RestController
@RequestMapping("/jp")
public class JobPlatformController {
	
	@Autowired
	JobPlatformRepository jobplatformrepo;
	
	@Autowired
	JobPlatformdao platformdao;
	
//	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
//	public JobPlatform createuser(@RequestBody JobPlatform platform) {
//			 	return platformdao.saveplatform(platform);
//		}
	
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<JobPlatform> createuser(@RequestBody JobPlatform platform) { {

	ResponseEntity<JobPlatform> response =null;
	JobPlatform status = null;
    

	try {
	status =platformdao.saveplatform(platform);
	response= new ResponseEntity<JobPlatform>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<JobPlatform>(status,HttpStatus.BAD_REQUEST);

	}

	return response;
	}
	}
	
	 @GetMapping("/getplatform")
	    public ResponseEntity<List<JobPlatform>> getAllEmployees() {
	 
	        List<JobPlatform> employees =platformdao.getAllplatfrom();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }
	 
		@PutMapping(path="/update/{id}",consumes = "application/json", produces = "application/json")
		public JobPlatform updateuser(@PathVariable(value = "id") Long id,@RequestBody JobPlatform emp) throws ResourceNotFoundException {
			platformdao.updateemp(id,emp);
			return emp;
		}
		
		@GetMapping("/users/{id}")
		public ResponseEntity<JobPlatform> getUserById(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
				return platformdao.finduserbyid(uid);
		}
		
		@DeleteMapping("/users/{id}")
		public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
				return platformdao.deleteuser(uid);
		}
}