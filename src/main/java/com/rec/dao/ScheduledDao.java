package com.rec.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rec.model.AnswersModel;
import com.rec.model.ApplicationModel;
import com.rec.model.SchedulesApplication;
import com.rec.repository.ScheduledRepository;

@Service
public class ScheduledDao {
@Autowired
private ScheduledRepository repo;

	public SchedulesApplication Save(SchedulesApplication data) {
		return repo.save(data);
	}

	public ResponseEntity<Object> deleteRole(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
            if (repo.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified scheduled");
            else return ResponseEntity.ok().body("Successfully deleted the specified scheduled");
        } else return ResponseEntity.badRequest().body("Cannot find the user specified scheduled");
	}

	@Transactional
	public ResponseEntity<Object> update(Long id, SchedulesApplication data) {
		   if(repo.findById(id).isPresent()) {
		    	SchedulesApplication newUser = repo.findById(id).get();
	     newUser.setApplicantId(data.getApplicantId());
	     newUser.setRecuiterId(data.getRecuiterId());
	     newUser.setMeetingName(data.getMeetingName());
	     newUser.setMeetingDescription(data.getMeetingDescription());
	     newUser.setScheduledDate(data.getScheduledDate());
	     newUser.setScheduledTime(data.getScheduledTime());
	     newUser.setPlatformLink(data.getPlatformLink());
	     newUser.setMeetingStatus(data.getMeetingStatus());
		    	SchedulesApplication savedUser = repo.save(newUser);
	            if(repo.findById(savedUser.getId()).isPresent())
	                return  ResponseEntity.accepted().body(" updated successfully");
	            else return ResponseEntity.unprocessableEntity().body("Failed updating specified");
	        } else return ResponseEntity.unprocessableEntity().body("Cannot find the specified");
	}

	public ResponseEntity<String> Scheduled(Long id) {
		 if(repo.findById(id).isPresent()) {
			 SchedulesApplication newUser = repo.findById(id).get();
	        newUser.setMeetingStatus("Scheduled");
	        SchedulesApplication savedUser = repo.save(newUser);
	            if(repo.findById(savedUser.getId()).isPresent())
	                return  ResponseEntity.accepted().body("status updated");
	            else return ResponseEntity.unprocessableEntity().body("Failed updating the status");
	        } else return ResponseEntity.unprocessableEntity().body("Cannot find the staus");
	}

	public ResponseEntity<String> Resheduled(Long id) {
		 if(repo.findById(id).isPresent()) {
			 SchedulesApplication newUser = repo.findById(id).get();
	        newUser.setMeetingStatus("ReScheduled");
	        SchedulesApplication savedUser = repo.save(newUser);
	            if(repo.findById(savedUser.getId()).isPresent())
	                return  ResponseEntity.accepted().body("status updated");
	            else return ResponseEntity.unprocessableEntity().body("Failed updating the status");
	        } else return ResponseEntity.unprocessableEntity().body("Cannot find the staus");
	}

}
