/**
 * 
 */
package com.Casestudy.CustomAnnotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * @author amahome
 *
 */

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {
	String message() default "Invalid email address";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};

}
