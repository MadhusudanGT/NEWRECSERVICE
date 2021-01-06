package com.rec.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rec.dao.service.UserService;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.RoleModel;
import com.rec.model.UserModel;
import com.rec.repository.UserRepository;
import com.rec.util.UserValidation;

@Service
public class Userdao implements UserService {
	
	@Autowired
	UserRepository repo;
	@Autowired
	UserValidation uservalidation;

	public UserModel Save(UserModel user) {
		System.out.print("success"+ user);
		return repo.save(user);
	}
	@Override
	public UserModel updateuser(Long id, UserModel data) throws ResourceNotFoundException {
		UserModel UserModelOptional = repo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));
         System.out.print("usermodeloptional"+UserModelOptional);
//         try {
		if(UserModelOptional!=null) {
		UserModelOptional.setId(id);
		System.out.println("id"+id);
		}
		if(data.getFirstName()!=null) {
			UserModelOptional.setFirstName(data.getFirstName());
		}
		if(data.getLastName()!=null) {
			UserModelOptional.setLastName(data.getLastName());
		}
//		if(data.getAdhar()!=null) {
//			UserModelOptional.setAdhar(data.getAdhar());
//		}
		if(uservalidation.isValid(data.getEmail())) {
			UserModelOptional.setEmail(data.getEmail());
		}
		if(data.getDOB()!=null) {
			UserModelOptional.setDOB(data.getDOB());
		}
		if(data.getStatus()!=null) {
			UserModelOptional.setStatus(data.getStatus());
		}
//         }catch(Exception e) {
//        	 System.out.print("Exception Found");
//         }
		UserModel updatedUser = this.repo.save(data);
		return updatedUser;
		}

		
		public ResponseEntity<UserModel> getUserById(Long uid) throws ResourceNotFoundException{
		// ResponseEntity<Optional> response=null;
		// UserModel status = null;
		// try {
		// status=repo.findById(uid)
		// .orElseThrow(()-> new Exception ("user not found"));
		// System.out.println("status"+status.getFirstname());
		//
		// }
		// catch(Exception e) {
		// response = new ResponseEntity<Optional>(HttpStatus.BAD_REQUEST);
		// throw new ResourceNotFoundException("user not found");
		// }
		//
		//
		UserModel status=repo.findById(uid).orElseThrow(() -> new ResourceNotFoundException("user not found"));
		
		
		return ResponseEntity.ok().body(status);
		}
		
		public List<UserModel> allUser(){
			return repo.findAll();
			}

			public UserModel addUser(@Valid UserModel user) {
			System.out.print("success"+ user);
			user.getRoles().addAll(user.getRoles());
			return this.repo.save(user);


			}
}
