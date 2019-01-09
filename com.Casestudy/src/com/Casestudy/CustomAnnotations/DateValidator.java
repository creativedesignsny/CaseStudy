package com.Casestudy.CustomAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.Casestudy.CustomAnnotations.DateValidateConstraint.ValidDate;


public class DateValidator implements ConstraintValidator<ValidDate, String> {
	
	public static final Pattern VALID_DATE_REGEX =
			Pattern.compile("^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$", Pattern.CASE_INSENSITIVE);
	public static boolean validate(String datestr) {
		Matcher matcher = VALID_DATE_REGEX.matcher(datestr);
		return matcher.find();
		
	}
	

	 @Override
	    public void initialize(ValidDate arg0) {
	    }

	    @Override
	    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
	    	boolean ans;
	    	if (validate(arg0)) {
				String[] dateString = arg0.split("/");
				LocalDate today = LocalDate.now();
				LocalDate yearDate = LocalDate.of(Integer.parseInt(dateString[2]), Integer.parseInt(dateString[0]), Integer.parseInt(dateString[1]));
				ans = yearDate.isBefore(today);
	    	}else {
	    		ans = false;
	    	}
			return (validate(arg0) && (ans==true));

	    }

}

