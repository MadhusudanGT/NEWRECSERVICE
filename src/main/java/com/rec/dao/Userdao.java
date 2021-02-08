package com.rec.dao;

import java.sql.Timestamp; 
import java.time.LocalDateTime;

import java.util.HashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
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
import com.rec.model.ContactModel;
import com.rec.model.RoleModel;
import com.rec.model.UserModel;
import com.rec.repository.RoleRepository;
import com.rec.repository.UserRepository;
import com.rec.util.UserValidation;

@Service
public class Userdao implements UserService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserValidation uservalidation;

	
	@Override
	public UserModel updateuser(Long id, UserModel data) throws ResourceNotFoundException {
		UserModel UserModelOptional = repo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));
         System.out.print("usermodeloptional"+UserModelOptional);
        UserModel updatedUser;

        try {
	        
	          if( (uservalidation.isLastName(data.getLastName())==true &&
	        		  uservalidation.isFirstName(data.getFirstName())==true) ||
	        		  (uservalidation.isEmailId(data.getEmail())==true &&
	        		  uservalidation.isDOB((CharSequence) data.getDOB())==true)||
	        		  (uservalidation.isAdhar(data.getAdhar())==true &&
	        		  uservalidation.isStatus(data.getStatus())==true))
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
			public Map<String, Boolean> deleteuser(Long id) 
				throws ResourceNotFoundException {
					UserModel existinguser = this.repo.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));
					Map<String, Boolean> response = new HashMap<>();
					UserModel roleid=this.repo.findUserID(id);
					if(roleid.getId()==1)
					{
						response.put("User id="+id+"is MANAGER id you can't make inactive", Boolean.FALSE);
					System.out.print("MANAGER id you can't make inactive");
					return response;
					}
					else{
						System.out.print("hr user");	
						existinguser.setStatus("inActive");
						repo.save(existinguser);
						response.put("User id="+id+" Change his status to InActive", Boolean.TRUE);
						return response;
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

			

			
			
	@Override
 	public ResponseEntity<Object> createUser(UserModel model) {
		UserModel user = new UserModel();
        if (repo.findByEmail(model.getEmail()).isPresent()) {
            return ResponseEntity.ok("The Email is already Present, Failed to Create new User");
        } else {
        	user.setId(model.getId());
            user.setFirstName(model.getFirstName());
            user.setLastName(model.getLastName());
            user.setDOB(model.getDOB());
            user.setAdhar(model.getAdhar());
            user.setStatus(model.getStatus());	
            user.setEmail(model.getEmail());
            ContactModel contact=model.getContact();
            user.setContact(contact);
            
            user.setCreatedAt(new Date());	
            List<RoleModel> role=model.getRoles();
             
            System.out.println("Role title===="+role.toString());
             
            user.setRoles(role);

            try {
            	 
            }
            catch(Exception e) {
            	
            	return ResponseEntity.unprocessableEntity().body("exception"+e);
            }
            		
            UserModel savedUser = repo.save(user);
         
            if (repo.findById(savedUser.getId()).isPresent())
                return ResponseEntity.ok("User Created Successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
        }
	}

}