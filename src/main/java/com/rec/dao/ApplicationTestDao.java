package com.rec.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rec.dao.service.ApplicationTestservice;
import com.rec.model.AnswersModel;
import com.rec.model.ApplicationTestModel;
import com.rec.model.TestModel;
import com.rec.repository.ApplicationTestRepo;
import com.rec.repository.TestRepo;

@Service
public class ApplicationTestDao implements ApplicationTestservice {
	@Autowired
	ApplicationTestRepo repo;
	
	
	
	

	public ApplicationTestModel Save(ApplicationTestModel ApplicationTest) {
		return repo.save(ApplicationTest);
	}




	@Override
	public ResponseEntity<Object> deleteRole(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
            if (repo.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Application test");
            else return ResponseEntity.ok().body("Successfully deleted the Application test");
        } else return ResponseEntity.badRequest().body("Cannot find the Application test specified");
	}




	@Override
	public ResponseEntity<Object> updateRole(Long id, ApplicationTestModel model) {
		 if(repo.findById(id).isPresent()) {
		     ApplicationTestModel newUser = repo.findById(id).get();
	            newUser.setTestid(model.getTestid());
	            newUser.setApplicationId(model.getApplicationId());
	            newUser.setStartTime(model.getStartTime());
	            newUser.setEndTime(model.getEndTime()); 
	            newUser.setAppltest(model.getAppltest());
	           ApplicationTestModel savedUser = repo.save(newUser);
	            if(repo.findById(savedUser.getId()).isPresent())
	                return  ResponseEntity.accepted().body("ApplicationTest updated successfully");
	            else return ResponseEntity.unprocessableEntity().body("Failed updating the Application");
	        } else return ResponseEntity.unprocessableEntity().body("Cannot find the Application specified");
	}
	

//    @Transactional
//	@Override
//	public ResponseEntity<Object> addApplicationtest(ApplicationTestModel model) {
//    	 ApplicationTestModel newApplicationTestModel = new ApplicationTestModel();
//	        newApplicationTestModel.setTestid(model.getTestid());
//	        newApplicationTestModel.setApplication(model.getApplication());
//	        newApplicationTestModel.setStartTime(model.getStartTime());
//	        newApplicationTestModel.setEndTime(model.getEndTime());
//	        
//	        List<ApplicationTestModel> ApplicationList = new ArrayList<>();
//	        ApplicationList.add(newApplicationTestModel);
//	        for(int i=0; i< model.getTest().size(); i++){
//	            if(!testrepo.findByCode(model.getTest().get(i).getCode()).isPresent()) {
//	                TestModel newUser = model.getTest().get(i);
//	                newUser.setApplicationTest(ApplicationList);
//	                TestModel savedUser = testrepo.save(newUser);
//	                if(!testrepo.findById(savedUser.getId()).isPresent())
//	                    return ResponseEntity.unprocessableEntity().body("Application Creation Failed");
//	            }
//	             else  return   ResponseEntity.unprocessableEntity().body("Test with this code is already Present");
//	        }
//	        return ResponseEntity.ok("Successfully created Role");
//		
//	}
//
//
//	public ResponseEntity<Object> deleteRole(Long id) {
//		
//		return null;
//	}



}