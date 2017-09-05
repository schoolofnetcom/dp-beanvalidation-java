package com.schoolofnet.BeanValidation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static Validator validator;
	
    public static void main( String[] args )
    {
    	ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    	validator = validatorFactory.getValidator();

    	PersonModel person = new PersonModel();
        
        person.setName(null);
        person.setAge(21);        
        person.setHeight(1.75);
        
        Set<ConstraintViolation<PersonModel>> constraintValidations = validator.validate(person);
    
        if (constraintValidations.size() > 0) {
        	System.out.println("Error " + constraintValidations.iterator().next().getMessage());
        } else {
            System.out.println(person.getName());
        	
        }
               
    }
}
