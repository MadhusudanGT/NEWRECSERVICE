package com.rec.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.AnswersModel;
//import com.rec.model.ApplicantModel;
//import com.rec.model.ApplicationModel;
import com.rec.model.JobModel;
import com.rec.model.JobPlatform;
import com.rec.model.JobPosition;
import com.rec.model.OrganizationModel;
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


@Transactional
public ResponseEntity<String> updatejob(Long id, JobModel job) throws ResourceNotFoundException {
	
    if(jobrepo.findById(id).isPresent()) {
    	JobModel newUser = jobrepo.findById(id).get();
      newUser.setName(job.getName());
      newUser.setDescription(job.getDescription());
      newUser.setDatePublished(job.getDatePublished());
      newUser.setStartingDate(job.getStartingDate());
      newUser.setVacancy(job.getVacancy());
      JobPlatform jobplatform=job.getJobPlatform();
      JobPosition jobposition=job.getJobPosition();
      OrganizationModel org=job.getOrganization();
      newUser.setJobPlatform(jobplatform);
      newUser.setJobPosition(jobposition);
      newUser.setOrganization(org);
      JobModel savedUser = jobrepo.save(newUser);
        if(jobrepo.findById(savedUser.getId()).isPresent())
            return  ResponseEntity.accepted().body("Answer updated successfully");
        else return ResponseEntity.unprocessableEntity().body("Failed updating the Answer specified");
    } else return ResponseEntity.unprocessableEntity().body("Cannot find the Answer specified");
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
