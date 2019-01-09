package com.Casestudy.CustomAnnotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String>{
	public static final Pattern VALID_PASSWORD_REGEX =
			Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%^&+=])[^\\s]{8,}$", Pattern.CASE_INSENSITIVE);
	public static boolean validate(String passwordstr) {
		Matcher matcher = VALID_PASSWORD_REGEX.matcher(passwordstr);
		return matcher.find();
	}
	
	@Override
	public void initialize(PasswordConstraint arg0) {
		
	}
	
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		
		return (validate(arg0) && (arg0.length() > 8));
	}
}
