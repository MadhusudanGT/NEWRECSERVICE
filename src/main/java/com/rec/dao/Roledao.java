package com.rec.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.model.RoleModel;
import com.rec.repository.RoleRepository;

@Service
public class Roledao {
	@Autowired
	RoleRepository role;
	
	public RoleModel Save(RoleModel Role) {
		System.out.print("success"+ Role);
		return role.save(Role);
	}
}
