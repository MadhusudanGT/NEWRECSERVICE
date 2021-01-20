package com.rec.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.HashMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import com.rec.util.Validation;

@Service
public class Userdao implements UserService {
	
	@Autowired
	UserRepository repo;
	@Autowired
	Validation validation;

	public UserModel Save(UserModel user) {
		System.out.print("success"+ user);
		
		return repo.save(user);
	}
	@Override
	public UserModel updateuser(Long id, UserModel data) throws ResourceNotFoundException {
		UserModel UserModelOptional = repo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));
         System.out.print("usermodeloptional"+UserModelOptional);
        UserModel updatedUser;

        try {
	        
	          if( (validation.isLastName(data.getLastName())==true &&
	        		  validation.isFirstName(data.getFirstName())==true) ||
	        		  (validation.isEmailId(data.getEmail())==true &&
	        		  validation.isDOB((CharSequence) data.getDOB())==true)||
	        		  (validation.isAdhar(data.getAdhar())==true &&
	        		 validation.isStatus(data.getStatus())==true))
	        		  {
	        	      System.out.println("successful");
		 			UserModelOptional.setFirstName(data.getFirstName());
		 			UserModelOptional.setLastName(data.getLastName());
		 			UserModelOptional.setEmail(data.getEmail());
		 			UserModelOptional.setStatus(data.getStatus());
		 			UserModelOptional.setDOB(data.getDOB());
		 			UserModelOptional.setAdhar(data.getAdhar());
		 			 updatedUser = this.repo.save(data);
		 			return updatedUser;
	         }
	       

         else
         {
        	 System.out.print("Insert data properly");
         }
        
        }
        catch(Exception e) {
        	System.out.print("Exception found");
        }
        return null;
    	
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
//			user.getRoles().addAll(user.getRoles());
			return this.repo.save(user);


			}
			
			
			@Override
			public List<UserModel> search(String keyword){
				System.out.println(keyword);
				return repo.search(keyword);
			}

			public List<UserModel> searchnumber(Long i) {
				System.out.print(i);
				return repo.searchnumbers(i);
				
			}
			
			
			@Override
			public UserModel deleteuser(Long id) 
				throws ResourceNotFoundException {
					UserModel existinguser = this.repo.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));
					RoleModel roleid=this.repo.findRoleID(id);
					if(roleid.getId()==1)
					{
					System.out.print("MANAGER id you can't make inactive");
					return existinguser;
					}
					else{
						System.out.print("hr user");	
						existinguser.setStatus("inActive");
						repo.save(existinguser);
						return existinguser;
					}
						
			}

			public List<UserModel> findByEmail(String keyword) {
				return repo.findByEmailid(keyword);

				}
				public List<UserModel> findbyphoneno(String phoneno) {
					return repo.findbyphoneno(phoneno);
					}
				public List<UserModel> finduserbydate(Date date) {
					return repo.finduserbydate(date);
					}
}
