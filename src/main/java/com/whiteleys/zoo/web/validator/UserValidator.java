package com.whiteleys.zoo.web.validator;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.whiteleys.zoo.dao.UserDao;
import com.whiteleys.zoo.domain.User;

public class UserValidator implements Validator {

	private UserDao userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		if (!user.getPassword().equals(user.getPassword2())) {
			errors.reject("passwordMismatch", "Both passwords must match");
		}
		
		if(this.userDao.exists(user.getUsername())) {
			errors.reject("duplicateUsername", "Username is already taken. Please choose a different username");
		}
		
		if(!this.isPostcodeValid(user.getPostcode())) {
			errors.reject("postcode", "invalid postcode");
		}
		
		
    	//Create the date of birth from the command
        Calendar cal = new GregorianCalendar();
        cal.set(user.getDobYear(), user.getDobMonth(), user.getDobDay(), 0, 0, 0);
        if(cal.getTimeInMillis() > new GregorianCalendar().getTimeInMillis()) {
        	errors.reject("dobInFuture", "Date of birth can't be a future date");
        }
	}

	
	/** Potentially calling web service/api to validated real postcode
	 * 
	 * @param postcode
	 * @return
	 */
	private boolean isPostcodeValid(String postcode) {
		return Util.isPostcodeValid(postcode);
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
