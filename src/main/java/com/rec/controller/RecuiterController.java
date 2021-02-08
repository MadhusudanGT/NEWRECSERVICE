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

import com.rec.dao.RecuiterDao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobModel;
import com.rec.model.Recruiters;
import com.rec.repository.RecuiterRepository;

@CrossOrigin 
@RestController
@RequestMapping("/rc")
public class RecuiterController {

	
	@Autowired
	private RecuiterDao recuiterdao;
	
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public Recruiters createRecuiter(@RequestBody Recruiters employee) {
	 System.out.print("job json object"+employee);
	 Recruiters emp = recuiterdao.addRecuiter(employee);
		        return emp;
		    
		}
	
	@GetMapping(path="/getall")
	public ResponseEntity<List<Recruiters>> getAllRecuiter() {
		 
        List<Recruiters> employees = recuiterdao.getAllRecuiter();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
	
	@PutMapping(path="/update/{id}",consumes = "application/json", produces = "application/json")
	public Recruiters updateuser(@PathVariable(value = "id") Long id,@RequestBody Recruiters emp) throws ResourceNotFoundException {
		recuiterdao.updateRecuiter(id,emp);
		return emp;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Recruiters> getRecuiterById(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
			return recuiterdao.findRecuiterbyid(uid);
	}
	
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteRecuiter(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
			return recuiterdao.deleteRecuiter(uid);
	}

}
