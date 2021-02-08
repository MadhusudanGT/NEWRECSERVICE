package com.rec.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.model.RegistrationModel;
import com.rec.repository.RegistrationRepository;

@Service
public class RegistrationDao {
@Autowired
RegistrationRepository regrepo;
public RegistrationModel Save(RegistrationModel app) {
System.out.print("success"+ app);
return regrepo.save(app);
}

}
