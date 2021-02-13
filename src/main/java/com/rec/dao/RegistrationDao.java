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
RegistrationModel reg=new RegistrationModel();
reg.setAddress(app.getAddress());
reg.setEmail(app.getEmail());
reg.setFirstName(app.getFirstName());
reg.setLastName(app.getLastName());
reg.setPhoneNo(app.getPhoneNo());
reg.setRegistredStatus(app.getRegistredStatus());
String encryptedpassword=getEncodedString(app.getPassword());
reg.setPassword(encryptedpassword);

return regrepo.save(reg);
}

private String getEncodedString(String password) {
	// TODO Auto-generated method stub
	return java.util.Base64.getEncoder().encodeToString(password.getBytes());
}

public RegistrationModel getByEmailId(String email) {
if(uservalidation.isregEmailId(email)) {
	System.out.print("valide eamil");
	return regrepo.findByEmailId(email);
}
return null;
}



}
