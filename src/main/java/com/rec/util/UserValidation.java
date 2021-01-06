package com.rec.util;

import javax.persistence.UniqueConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.dao.Userdao;
import com.rec.model.UserModel;
@Service
public class UserValidation implements ConstraintValidator<UniqueConstraint, String> {
    
	
    @Override
    public void initialize(UniqueConstraint Email) {
    }

    public boolean isValid(String email) {
    	boolean val;
        val= email != null && email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$s")
          && (email.length() > 8) && (email.length() < 14);
        System.out.print("validated value"+val);
        return val;
    }


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
