package com.rec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rec.dao.RegistrationDao;
import com.rec.model.RegistrationModel;
import com.rec.repository.RegistrationRepository;

@CrossOrigin
@RestController
@RequestMapping("/reg")
public class RegistrationController {
@Autowired
private RegistrationDao regdao;

@Autowired
RegistrationRepository regrepo;

@GetMapping("/getAll")
public List<RegistrationModel> getAll(){
return regrepo.findAll();
}


@PostMapping(path="/create",consumes = "application/json", produces = "application/json")
public RegistrationModel createRegistration(@RequestBody RegistrationModel app) {
RegistrationModel ref =regdao.Save(app);
return ref;
}
}

