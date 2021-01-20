package com.rec.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicantModel;
import com.rec.model.ApplicationModel;
import com.rec.model.JobModel;
import com.rec.repository.JobRepository;
@Service
public class JobDao {
	@Autowired
	JobRepository jobrepo;

	public JobModel Save(JobModel job) {
		System.out.print("success"+ job);
		
		return jobrepo.save(job);
	}

	public ResponseEntity<JobModel> getJobById(Long jobid) throws ResourceNotFoundException{
	
		JobModel status=jobrepo.findById(jobid).orElseThrow(() -> new ResourceNotFoundException("job not found"));
		
		
		return ResponseEntity.ok().body(status);
		}
	
	public JobModel updatejob(Long id, JobModel job) throws ResourceNotFoundException {
		JobModel ApplicationModelOptional = jobrepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("job not found for this id :: " + id));
         System.out.print("applicationmodeloptional"+ApplicationModelOptional);
        JobModel updatedJob;

        try {  
		 			 updatedJob = this.jobrepo.save(job);
		 			return job;
	         }
	       
        catch(Exception e) {
        	System.out.print("Exception found");
        }
        return null;
    	
	}
	
	public Map<String, Boolean> deletejob(Long jobid) throws ResourceNotFoundException {
		JobModel user = this.jobrepo.findById(jobid)
		.orElseThrow(() -> new ResourceNotFoundException("job not found for this id :: " + jobid));
		
		this.jobrepo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		}
}
