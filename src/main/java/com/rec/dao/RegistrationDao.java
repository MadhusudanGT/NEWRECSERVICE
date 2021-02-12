package com.rec.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.RegistrationModel;
import com.rec.model.UserModel;
import com.rec.repository.RegistrationRepository;
import com.rec.util.UserValidation;

@Service
public class RegistrationDao {
@Autowired
RegistrationRepository regrepo;

@Autowired
UserValidation uservalidation;

public RegistrationModel Save(RegistrationModel app) {
System.out.print("success"+ app);
return regrepo.save(app);
}

public RegistrationModel getByEmailId(String email) {
if(uservalidation.isregEmailId(email)) {
	System.out.print("valide eamil");
	return regrepo.findByEmailId(email);
}
return null;
}



}
