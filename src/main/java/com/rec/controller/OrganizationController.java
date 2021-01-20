package com.rec.controller;

import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.JobOriginatingUserName;

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

import com.rec.dao.Organizationdao;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobPosition;
import com.rec.model.OrganizationModel;
import com.rec.repository.JobPositionRepository;
import com.rec.repository.OrganizationRepository;

@CrossOrigin 
@RestController
@RequestMapping("/jo")
public class OrganizationController {
	@Autowired
	 Organizationdao orgdao;

	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public OrganizationModel createuser(@RequestBody OrganizationModel org) {
			 	return orgdao.saveposition(org);
		}

	 @GetMapping("/getplatform")
	    public ResponseEntity<List<OrganizationModel>> getAllEmployees() {
	 
	        List<OrganizationModel> employees =orgdao.getAllposition();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }
	 
		@PutMapping(path="/update/{id}",consumes = "application/json", produces = "application/json")
		public OrganizationModel updateuser(@PathVariable(value = "id") Long id,@RequestBody OrganizationModel emp) throws ResourceNotFoundException {
			orgdao.updateemp(id,emp);
			return emp;
		}
		
		@GetMapping("/users/{id}")
		public ResponseEntity<OrganizationModel> getUserById(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
				return orgdao.finduserbyid(uid);
		}
		
		@DeleteMapping("/users/{id}")
		public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException{
				return orgdao.deleteuser(uid);
		}

}