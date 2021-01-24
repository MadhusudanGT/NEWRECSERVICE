package com.rec.dao.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.rec.exception.ResourceNotFoundException;
import com.rec.model.UserModel;


public interface UserService {
	UserModel updateuser(Long id,UserModel data) throws ResourceNotFoundException;
	UserModel addUser(UserModel usermodel);
	 Map<String, Boolean> deleteuser(Long id) throws ResourceNotFoundException;
	
	List<UserModel> search(String keyword);
	ResponseEntity<Object> createUser(UserModel model);
	

}
