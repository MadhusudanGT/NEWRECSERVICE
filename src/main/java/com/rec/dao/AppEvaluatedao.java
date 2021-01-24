package com.rec.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rec.dao.service.ApplicationEvaluateService;
import com.rec.model.ApplicationEvaluation;
import com.rec.model.Recruiters;
import com.rec.repository.ApplicationREvaluteepository;
import com.rec.repository.RecruiterRepository;

@Service
public class AppEvaluatedao implements ApplicationEvaluateService{

	@Autowired
	ApplicationREvaluteepository apprepo;
	
	@Autowired 
	RecruiterRepository recrepo;
	
public ResponseEntity<Object> getAll(){
		
		
		List<ApplicationEvaluation> res= apprepo.findAll();
		
		return ResponseEntity.accepted().body(res);
	}
	
	 @Override
	 @Transactional
		public ResponseEntity<Object> saveappEvaluate(ApplicationEvaluation appev){
			ResponseEntity<Object> res=null;
			ApplicationEvaluation newapp=new ApplicationEvaluation();
			newapp.setId(appev.getId());
			newapp.setHired(appev.isHired());
			newapp.setNotes(appev.getNotes());
			Recruiters rec=appev.getRecruiter();
			
			if(recrepo.findByfirstName(rec.getFirstName())!=null) {
				 Recruiters recruiter=null;
				 recruiter=recrepo.findByfirstName(rec.getFirstName());
				System.out.print("ID=======" +recruiter.getId());
				
				newapp.setRecruiter(recruiter);
			}
			else {
				newapp.setRecruiter(appev.getRecruiter());
			}
		 
		  try {
//				 Recruiters recruiter=null;
//				 recruiter=recrepo.findByfirstName(rec.getFirstName());
//				  System.out.print("ID=======" +recruiter.getId());

//			  	if(recruiter!=null) {
//				  System.out.println("i am in if");
//				  Recruiters newrecruiter=new Recruiters();
//				  newrecruiter.setId(recruiter.getId());
//				  newrecruiter.setApplication(recruiter.getApplication());
//				  newrecruiter.setFirstName(recruiter.getFirstName());
//				  newrecruiter.setLastName(recruiter.getLastName());
//				  newapp.setRecruiter(newrecruiter);
//				  
//				  System.out.println("last name"+newapp.getRecruiter().getId());
//				  
//			  }
//			  else {
//				  System.out.println("i am in else");
//				  newapp.setRecruiter(appev.getRecruiter());
//			  }
			  
			   ApplicationEvaluation saveapp=apprepo.save(newapp);
			   System.out.println("id=="+saveapp.getRecruiter().getId());
			  
			  if (apprepo.findById(saveapp.getId()).isPresent()) {
		            return  ResponseEntity.accepted().body(saveapp);
		        } 
			  else {
		            return ResponseEntity.unprocessableEntity().body("Failed to Create app	");
			  	}
		  }
		  catch(Exception e) {
			  return ResponseEntity.unprocessableEntity().body("Failed to Create"+e);
			  
		  }
	  }
	 
	 
	 
	 @Override
	 @Transactional
	public ResponseEntity<Object> deleteByid(Long id) {
		// TODO Auto-generated method stub
		try {
			
		 
		if(apprepo.findById(id)!=null) {
			
			apprepo.deleteById(id);
			return ResponseEntity.accepted().body("deleted succesfully");
		}
		else {
			return ResponseEntity.accepted().body("no data found");
		}
		}
		catch(Exception e) {
			return ResponseEntity.accepted().body("no data found"+e);
		}
	 
		
	}
	 @Override
	 @Transactional
	public ResponseEntity<Object> updateByid(ApplicationEvaluation appev) {
		// TODO Auto-generated method stub
		ResponseEntity<Object> res=null;
		 ApplicationEvaluation newapp=new ApplicationEvaluation();
		 newapp.setId(appev.getId());
		 newapp.setHired(appev.isHired());
		 newapp.setNotes(appev.getNotes());
		   newapp.setRecruiter(appev.getRecruiter());
		   try {
			   
			   ApplicationEvaluation save= apprepo.save(newapp);
			   return ResponseEntity.unprocessableEntity().body(save);
		   }
			  
		 catch (Exception e) {
			 return ResponseEntity.unprocessableEntity().body(" failed to upaate"+e);
			  
		 }
			 
			  
		  }

	@Override
	@Transactional
	public ResponseEntity<Object> getById(long id) {
		// TODO Auto-generated method stub
		try {
			Object res= apprepo.findById(id);
			 
			if(res!=null) {
				
				
				return ResponseEntity.accepted().body(res);
			}
			else {
				return ResponseEntity.accepted().body("no data found");
			}
			}
			catch(Exception e) {
				return ResponseEntity.accepted().body("no data found"+e);
			}
	
	 
	}
	
	
	
	 
	  }