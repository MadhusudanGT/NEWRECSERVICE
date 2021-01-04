package com.rec.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.dao.Roledao;
import com.rec.model.ContactModel;
import com.rec.model.RoleModel;
import com.rec.model.UserModel;
import com.rec.repository.RoleRepository;
import com.rec.repository.UserRepository;


@CrossOrigin 
@RestController
@RequestMapping("/role")


public class RoleController {
	@Autowired
	 Roledao roleservice;
	 
	 @Autowired
	 RoleRepository rolerepo;
	 
	 @Autowired
	 UserRepository usr; 
	@GetMapping("/")
	public String get() {
		return "home";
	}
	
	
 
	@PostMapping(path="/create/{userId}",consumes = "application/json", produces = "application/json")
	
		
	 
	 public <U> ResponseEntity<RoleModel> createcontact( @PathVariable (value = "userId") Long userid,@RequestBody RoleModel role){
		 System.out.println("uid"+userid);
		 ResponseEntity<RoleModel> response = null;
		 RoleModel status;
		 
			  try {
				  status=roleservice.Save(userid, role);
				  response = new ResponseEntity<RoleModel>(status,HttpStatus.OK);
				  
			  }
			  catch(Exception e) {
				  
			  }
			return response ;
		 
	 
		 
		
	 }
	 
	 

	 
}
