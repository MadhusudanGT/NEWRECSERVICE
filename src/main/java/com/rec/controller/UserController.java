package com.rec.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.exception.ResourceNotFoundException;
//import com.mycart.model.User;
//import com.mycart.model.User;
//import com.mycart.model.User;
import com.rec.dao.Contactdao;
import com.rec.dao.Userdao;
import com.rec.dao.service.UserService;
import com.rec.model.ContactModel;
import com.rec.model.RoleModel;
import com.rec.model.UserModel;
import com.rec.repository.ContactRepo;
import com.rec.repository.UserRepository;
//import com.rec.util.UserValidation;


@CrossOrigin 
@RestController
@Validated
@RequestMapping("/usr")
public class UserController {
	
	@Autowired
	Userdao userservice;
	@Autowired
	UserRepository repo;
//	@Autowired
//	UserValidation userval;
	@GetMapping("/")
	public String get() {
		return "home";
	}
	
	@PutMapping("/update/{id}")
	public UserModel updateuser(@PathVariable(value="id") Long id,@Valid @RequestBody UserModel data) throws ResourceNotFoundException {
	System.out.println(id+" "+data);
//	userval.validate(UniqueConstraint., bindingResult);
	return userservice.updateuser(id,data);

	}
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserModel> createuser(@RequestBody UserModel data) {

	ResponseEntity<UserModel> response =null;
	UserModel status = null;
    

	try {
	status =userservice.Save(data);
	response= new ResponseEntity<UserModel>(status, HttpStatus.OK);
	}
	catch(Exception e) {
	response = new ResponseEntity<UserModel>(status,HttpStatus.BAD_REQUEST);

		ResponseEntity<UserModel> response1 =null;
		UserModel status1 = null;
		 try {
			 status1 =userservice.Save(data);
			 response1= new ResponseEntity<UserModel>(status1, HttpStatus.OK);
		 }
		 catch(Exception e1) {
			 response1 = new ResponseEntity<UserModel>(status1,HttpStatus.BAD_REQUEST);
		 }
		
		
		
		
		 return  response1;

	}




	return response;
	}


	@GetMapping(path="/user/{UserId}" , produces="application/json")
	public ResponseEntity<UserModel> getById(@PathVariable(value="UserId") long UserId) throws ResourceNotFoundException {



	return userservice.getUserById(UserId);
	} 
	
	@GetMapping("/users")
	public List<UserModel> getAll(){
	return repo.findAll();
	}

//	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
//	public UserModel createuser(@Valid @RequestBody UserModel data) {
//
//	System.out.print("success"+ data );
//
//	return userservice.addUser(data);
//	}
	
	@GetMapping(path="/search")
	public List<UserModel> search(@Param("keyword") String keyword) {
		try {
			if (isWord(keyword)) {
				 System.out.print("string");
				 List<UserModel> result=userservice.search(keyword);
				 return result;
			 }
			 else if(isNumber(keyword)) {
				 System.out.print("number");
				 Long i=Long.parseLong(keyword);
//				 System.out.print(i);
				 List<UserModel> result=userservice.searchnumber(i);
				 System.out.print(result);
				 return result;
			 }
			 else if(isDate(keyword)) { 
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				 Timestamp fdt = new Timestamp ((df.parse(keyword)).getTime());
				 LocalDateTime currentdate=LocalDateTime.now();
				System.out.print(fdt);
				System.out.print(currentdate);
	      List<UserModel> result= userservice.finduserbydate(fdt,currentdate);
				      	return result;
			    
			 }
			 else if(isPhoneNo(keyword)) {
				 System.out.print("it is phone no"+keyword);
				 List<RoleModel> result=userservice.findbyphoneno(keyword);
				 System.out.print(result);
				 return null;
			 }
			 
			 else{
				 System.out.println("combination of string and number");
				 List<UserModel> result=userservice.findByEmail(keyword);
				 return result;
				
				 
			 }
			
		}catch(Exception e) {
			
	
		}
		 return null; 
	}

	private boolean isPhoneNo(String keyword) {
		if(keyword.length()>=10) {
			return Pattern.matches("[0-9]+", keyword);
		}
		return false;
		
	}

	private boolean isDate(String keyword) {
		return Pattern.matches("^[0-9]{4}-(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9]$)", keyword);
	}
	private boolean isNumber(String keyword) {
		if(keyword.length()<=5) {
		return Pattern.matches("[0-9]+", keyword);
	
		}
		return false;
	}
	private boolean isWord(String keyword) {
		return Pattern.matches("[a-zA-Z]+",keyword);
		
	}
	
	@DeleteMapping("/users/{id}")
	public UserModel deleteUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
			return userservice.deleteuser(id);
	}

	}
