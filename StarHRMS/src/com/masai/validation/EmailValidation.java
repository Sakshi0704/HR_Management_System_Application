package com.masai.validation;

import java.util.regex.Pattern;


/**
 * The EmailValidation class provides methods for validating email addresses.
 * 
 * The emailValidation method validates an email address based on a regular expression pattern.
 * 
 * It checks if the email address is null or empty, and then matches it against the pattern.
 * 
 * @author Km Sakshi
 */
public class EmailValidation {

	/**
	 * Validates an email address.
	 * @param email The email address to be validated.
	 * @return {@code true} if the email is valid, {@code false} otherwise.
	 */
	public Boolean emailValidation(String email) {
		
	    // Check if the email is null or empty
	    if (email == null || email.isEmpty()) {
	        return false;
	    }
	    
	    
	    // Regular expression pattern for email validation
	    String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" +
	            "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	    
	    // Compile the pattern
	    Pattern pattern = Pattern.compile(emailRegex);
	    
	    
	    // Match the email against the pattern
	    if (pattern.matcher(email).matches()) {
	        return true;
	    } else {
	        return false;
	    }
	}
}