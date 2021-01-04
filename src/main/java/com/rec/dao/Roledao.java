package com.rec.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.model.RoleModel;
import com.rec.model.UserModel;
import com.rec.repository.RoleRepository;
import com.rec.repository.UserRepository;

@Service
public class Roledao {
	@Autowired
	RoleRepository role;
	@Autowired
	 Roledao roleservice;
	 
	 @Autowired
	 RoleRepository rolerepo;
	 
	 @Autowired
	 UserRepository usr; 
	
	public <U> RoleModel Save( Long userid, RoleModel role) {
		Date date= new Date();
        
	 long time = date.getTime();
        
	 Timestamp ts = new Timestamp(time);
		
		 usr.findById(userid).map((Function<? super UserModel, ? extends U>) user ->{
			 System.out.println("user"+user.getDOB());
			 
			 List<UserModel> userlist= new ArrayList<>();
			 	userlist.add((UserModel) user);
			role.setUserID(userlist);
			role.setCreatedAt(ts);
			rolerepo.save(role);
			return (U) role;
			
		}) ;
		return role;
		 
	 
		 
	}
}
