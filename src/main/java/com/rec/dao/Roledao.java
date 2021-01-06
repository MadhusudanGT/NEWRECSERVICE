package com.rec.dao;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;

import com.rec.dao.service.RoleService;
import com.rec.model.RoleModel;
import com.rec.repository.RoleRepository;


@Service
public class Roledao implements RoleService {
@Autowired
RoleRepository repo;




@Override
public List<RoleModel> getAllRoles() {
return this.repo.findAll();
}

@Override
public Optional<RoleModel> getRole(long id) {
return this.repo.findById(id);
}

@Override
public RoleModel saveRole(@Valid RoleModel role) {
role.setUpdatedAt(null);
return this.repo.save(role);

}


@Override
public Map<String, Boolean> deleteRole(long id)throws ResourceNotFoundException {
RoleModel rolemodel = this.repo.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

this.repo.delete(rolemodel);
Map<String, Boolean> response = new HashMap<>();
response.put("deleted", Boolean.TRUE);
return response;
}

@Override
public RoleModel updateRole(long id,RoleModel role) throws ResourceNotFoundException {
RoleModel rolemodel = this.repo.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
role.setCreatedAt(rolemodel.getCreatedAt());
role.setUpdatedAt(new java.util.Date());
final RoleModel updatedrole = this.repo.save(role);
return updatedrole;
}
}
=======
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
>>>>>>> cbaf408b641e164eef2ffc271e4a1e97d7188205
