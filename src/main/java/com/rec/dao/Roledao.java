package com.rec.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;

import com.rec.dao.service.RoleService;
import com.rec.model.Recruiters;
import com.rec.model.RoleModel;
import com.rec.model.UserModel;
import com.rec.repository.RoleRepository;
import com.rec.repository.UserRepository;


@Service
public class Roledao implements RoleService {
		@Autowired
		RoleRepository repo;
		
		@Autowired
		UserRepository userRepository;
		
		
		@Override
		public List<RoleModel> getAllRoles() {
		return this.repo.findAll();
		}
		
		@Override
		public Optional<RoleModel> getRole(long id) {
		return this.repo.findById(id);
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
			try {	     
				 RoleModel jpupdate = this.repo.save(role);
		 			return jpupdate;
		    }
		  
		catch(Exception e) {
			System.out.print("Exception found");
		}
		return null;
		}

	@Override
	public ResponseEntity<Object> addRole(RoleModel role) {
        RoleModel newRole = new RoleModel();
        newRole.setTitle(role.getTitle());
        newRole.setDescription(role.getDescription());
        newRole.setCreatedAt(new Date());
        
        
        List<UserModel> users=role.getUsers();
         
        newRole.setUsers(users);
        repo.save(newRole);
         
//        List<RoleModel> roleList = new ArrayList<>();
//        roleList.add(newRole);
//        for(int i=0; i< role.getUsers().size(); i++){
//            if(!userRepository.findByEmail(role.getUsers().get(i).getEmail()).isPresent()) {
//                UserModel newUser = role.getUsers().get(i);
//                newUser.setRoles(roleList);
//                UserModel savedUser = userRepository.save(newUser);
//                if(! userRepository.findById(savedUser.getId()).isPresent())
//                    return ResponseEntity.unprocessableEntity().body("Role Creation Failed");
//            }
//             else  return   ResponseEntity.unprocessableEntity().body("User with email Id is already Present");
//        }
        return ResponseEntity.ok("Successfully created Role");
		
	}

	@Override
	public RoleModel saveRole(RoleModel role) {
		// TODO Auto-generated method stub
		return null;
	}
}