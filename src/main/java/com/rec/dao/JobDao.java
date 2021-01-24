package com.rec.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobModel;
import com.rec.model.JobPlatform;
import com.rec.model.JobPosition;
import com.rec.model.OrganizationModel;
import com.rec.repository.JobPlatformRepository;
import com.rec.repository.JobPositionRepository;
import com.rec.repository.JobRepository;
import com.rec.repository.OrganizationRepository;

@Service
public class JobDao {

	@Autowired
	JobPlatformRepository jobplatformrepo;
	
	@Autowired
	JobPositionRepository jobpositionrepo;
	
	@Autowired
	OrganizationRepository organizationrepo;
	
	@Autowired
	JobRepository jobrepo;
	

		public JobModel addEmployee(JobModel employee){
			
			return jobrepo.save(employee);
		  
	 }
		
		
public JobModel updateemp(Long id,JobModel employee) 
	throws ResourceNotFoundException {
		JobModel jb = jobrepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("application not found for this id :: " + id));
         System.out.print("applicationmodeloptional"+jb);
        JobModel updatedApplication;
   	 jb.setId(id);
   	 jb.setName(employee.getName());
   	 jb.setDescription(employee.getDescription());
   	 jb.setVacancy(employee.getVacancy());
   	 jb.setStartingDate(employee.getStartingDate());
   	 jb.setEndingDate(employee.getEndingDate());
   	 jb.setDatePublished(employee.getDatePublished());
	
   	 JobPlatform jobplatform=employee.getJobPlatform();
		JobPosition jobposition=employee.getJobPosition();
		OrganizationModel org=employee.getOrganization();
		jb.setJobPlatform(jobplatform);
		 jb.setJobPosition(jobposition);
		 jb.setOrganization(org);
        try {	     
		 			JobModel jpupdate = this.jobrepo.save(jb);
		 			return jb;
	         }
	       
        catch(Exception e) {
        	System.out.print("Exception found");
        }
        return null;
    	
//	JobModel jb = jobrepo.findById(id)
//	.orElseThrow(() -> new ResourceNotFoundException("applicant not found for this id :: " + id));
//     System.out.print("applicantmodeloptional"+jb);
//
//	 
//	 jb.setId(id);
//	 jb.setName(employee.getName());
//	 jb.setDescription(employee.getDescription());
//	 jb.setVacancy(employee.getVacancy());
//	 jb.setStartingDate(employee.getStartingDate());
//	 jb.setEndingDate(employee.getEndingDate());
//	 jb.setDatePublished(employee.getDatePublished());
//	 
//	 JobPlatform jobplatform=employee.getJobPlatform();
//	JobPosition jobposition=employee.getJobPosition();
//	OrganizationModel org=employee.getOrganization();
//	 
//	  try {
////		 JobPlatform platform=jobplatformrepo.findByfirstName(jobplatform.getPlatformName());
//		 jb.setJobPlatform(jobplatform);
//		 jb.setJobPosition(jobposition);
//		 jb.setOrganization(org);
//		 
//		JobModel savejb= jobrepo.save(jb);
//		
//		System.out.print(savejb.getJobPlatform());
//		
//		jb.setJobPlatform(employee.getJobPlatform());
//		 jb.setJobPosition(employee.getJobPosition());
//		 jb.setOrganization(employee.getOrganization());
//		 
//		  if (jobrepo.findById(savejb.getId()).isPresent()) {
//		            return ResponseEntity.accepted().body(savejb);
//		        } 
//		  else {
//		            return ResponseEntity.unprocessableEntity().body("Failed to Create app	");
//			  	}		
//	  }
//	  catch(Exception e) {
//			  return ResponseEntity.unprocessableEntity().body("Failed to Create"+e);
////			  
//		  }
		}

		public List<JobModel> getAllEmployees() {
			 return jobrepo.findAll();
		}
		
		public Map<String, Boolean> deleteuser(Long uid) throws ResourceNotFoundException {
			JobModel user = this.jobrepo.findById(uid)
					.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + uid));

			this.jobrepo.delete(user);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
		
		
		public ResponseEntity<JobModel> finduserbyid(Long uid) throws com.rec.exception.ResourceNotFoundException {
			JobModel user = this.jobrepo.findById(uid)
					.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + uid));
			return ResponseEntity.ok().body(user);
		}
}