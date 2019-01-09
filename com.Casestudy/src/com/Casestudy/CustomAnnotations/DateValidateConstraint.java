package com.Casestudy.CustomAnnotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

public interface DateValidateConstraint {
	
	@Documented
	@Target( {ElementType.METHOD, ElementType.FIELD })
	@Retention(RetentionPolicy.RUNTIME)
	@Constraint(validatedBy = DateValidator.class)
	public @interface ValidDate {

	    String message() default "invalid date";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};

	    boolean optional() default false;
	}

}
