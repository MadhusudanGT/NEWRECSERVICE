package com.rec.util;
import java.util.Date;
import java.util.regex.Pattern;
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
    	System.out.print("email"+email);
    	boolean val;
        val= email != null && email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$s")
          && (email.length() > 8) && (email.length() < 14);
        System.out.print("validated value"+val);
        return val;
    }
    public boolean isDate(String keyword) {
    	return Pattern.matches("^[0-9]{4}-(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9]$)", keyword);
    }
    public boolean isDOB(CharSequence charSequence) {
    	return Pattern.matches("^[0-9]{4}-(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9]$)", charSequence);
    }
    public boolean isNumber(String keyword) {
    	if(keyword.length()<=5) {
    	return Pattern.matches("[0-9]+", keyword);

    	}
    	return false;
    }
    public boolean isWord(String keyword) {
    	return Pattern.matches("[a-zA-Z]+",keyword);
    	
    }
    public static boolean isEmailId(String keyword) {
    	System.out.print(keyword);
    	if(keyword.length()>=10) {
    		return Pattern.matches("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$", keyword);
		}
		return false;
		
    }
    public static boolean isFirstName(String keyword) {
    	System.out.print(keyword);
    	if(keyword.length()>=3) {
    	return Pattern.matches("[a-zA-Z]+", keyword);
    	}
    	return false;
    }
    public static boolean isLastName(String keyword) {
    	System.out.print(keyword);
    	if(keyword.length()>=3) {
    	return Pattern.matches("[a-zA-Z]+", keyword);
    	}
    	return false;
    }
    public static boolean isStatus(String keyword) {
    	if(keyword.length()>=6) {
    	System.out.print(keyword);
    	return Pattern.matches("[a-zA-Z]+", keyword);
    	}
    	return false;
    }
    public static boolean isAdhar(CharSequence keyword) {
    	System.out.print(keyword);
    	return Pattern.matches("[0-9]+", keyword);
    }
   
    
    public static boolean isPhoneNo(String keyword) {
    	System.out.print(keyword);
    		if(keyword.length()>=10) {
    			return Pattern.matches("[0-9]+", keyword);
    		}
    		return false;
    		
    	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
