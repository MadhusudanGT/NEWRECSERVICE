package com.rec.controller;

import java.util.List;

//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import java.util.Map;
//import java.util.Optional;
//import java.util.function.Function;
//
//import javax.validation.Valid;
//
//
//import java.util.Optional;
//import java.util.function.Function;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rec.dao.Roledao;
import com.rec.dao.TestDao;
import com.rec.exception.ResourceNotFoundException;


import com.rec.model.ContactModel;
import com.rec.model.RoleModel;
import com.rec.model.TestModel;
import com.rec.model.UserModel;
import com.rec.repository.RoleRepository;
import com.rec.repository.TestRepo;
import com.rec.repository.UserRepository;



@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
@Autowired
TestDao testservice;

@Autowired
TestRepo testrepo;

@PostMapping("/create")
public ResponseEntity<Object> createUser(@RequestBody TestModel test) {
  return testservice.createUser(test);
}

@GetMapping("/get/{id}")
public TestModel getUser(@PathVariable Long id) {
  if(testrepo.findById(id).isPresent())
      return testrepo.findById(id).get();
  else return  null;
}
//@GetMapping("/user/all")
//public List<User> getUsers() {
//  return userRepository.findAll();
//}
//@PutMapping("/user/update/{id}")
//public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
//  return testservice.updateUser(user, id);
//}
//@DeleteMapping("user/delete/{id}")
//public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
//  return testservice.deleteUser(id);
//}

//@GetMapping("/get")
//public List<TestModel> findall(){
//return this.testservice.getall();
//}


}
