package com.rec.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import javax.validation.Valid;


import java.util.Optional;
import java.util.function.Function;


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

import com.rec.exception.ResourceNotFoundException;


import com.rec.model.ContactModel;
import com.rec.model.RoleModel;
import com.rec.model.UserModel;
import com.rec.repository.RoleRepository;
import com.rec.repository.UserRepository;



@CrossOrigin
@RestController
@RequestMapping("/rr")


public class RoleController {
@Autowired
Roledao roleservice;

@Autowired
RoleRepository rolerepo;

@GetMapping("/roles")
public List<RoleModel> allRoles(){
return roleservice.getAllRoles();
}

@GetMapping("/role/{id}")
public Optional<RoleModel> getRole(@PathVariable(value = "id") Long id){
return this.roleservice.getRole(id);
}


@PostMapping("/role")
public RoleModel addRole(@Valid @RequestBody RoleModel data) {
return this.roleservice.saveRole(data);
}

@PutMapping("/role/{id}")
public RoleModel updateRole(@Valid @RequestBody RoleModel data,@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
return this.roleservice.updateRole(id, data);
}


@DeleteMapping("/role/{id}")
public Map<String, Boolean> deleteRole(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
return this.roleservice.deleteRole(id);
}


}
