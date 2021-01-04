package com.rec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.dao.Roledao;
import com.rec.model.RoleModel;


@CrossOrigin 
@RestController
@RequestMapping("/role")


public class RoleController {
	@Autowired
	 Roledao roleservice;
	 
	 
	@GetMapping("/")
//	public String get() {
//		return "home";
//	}
	@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
	public RoleModel createuser(@RequestBody RoleModel data) {
		
		System.out.print("success"+ data );
	 
		 return roleservice.Save(data);
	}
}
