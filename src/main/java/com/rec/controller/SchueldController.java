package com.rec.controller;

import java.util.List;

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

import com.rec.dao.ScheduledDao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.AnswersModel;
import com.rec.model.ApplicationModel;
import com.rec.model.SchedulesApplication;
import com.rec.repository.ScheduledRepository;

@CrossOrigin
@RestController
@RequestMapping("/Scheduled")
public class SchueldController {
@Autowired
private ScheduledRepository repo;

@Autowired
private ScheduledDao dao;

@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
public ResponseEntity<SchedulesApplication> createuser(@RequestBody SchedulesApplication data) {

ResponseEntity<SchedulesApplication> response =null;
SchedulesApplication status = null;


try {
status =dao.Save(data);
response= new ResponseEntity<SchedulesApplication>(status, HttpStatus.OK);
}
catch(Exception e) {
response = new ResponseEntity<SchedulesApplication>(status,HttpStatus.BAD_REQUEST);

	ResponseEntity<SchedulesApplication> response1 =null;
	SchedulesApplication status1 = null;
	 try {
		 status1 =dao.Save(data);
		 response1= new ResponseEntity<SchedulesApplication>(status1, HttpStatus.OK);
	 }
	 catch(Exception e1) {
		 response1 = new ResponseEntity<SchedulesApplication>(status1,HttpStatus.BAD_REQUEST);
	 }
	
	 return  response1;

}
return response;
}

@DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return dao.deleteRole(id);
    }
    @GetMapping("/getmeetingid/{id}")
    public SchedulesApplication getAnswers(@PathVariable Long id) {
        if(repo.findById(id).isPresent())
            return repo.findById(id).get();
        else return null;
    }
    @GetMapping("/getall")
    public List<SchedulesApplication> getRoles() {
        return repo.findAll();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SchedulesApplication data) {
        return dao.update(id, data);
    }
    
    @GetMapping("/scheduled/{id}")
	public ResponseEntity<String> AcceptApplication(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		return this.dao.Scheduled(id);
	}

@GetMapping("/rescheduled/{id}")
public ResponseEntity<String> RejectApplication(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
	return this.dao.Resheduled(id);
}

}
