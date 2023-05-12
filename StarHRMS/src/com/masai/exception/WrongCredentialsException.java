package com.masai.exception;

/**
 * Custom exception class for handling wrong credentials. This exception is
 * thrown when there are incorrect credentials provided for authentication. It
 * extends the Exception class and provides a custom constructor to set an error
 * message.
 * 
 * @author Km Sakshi
 */
public class WrongCredentialsException extends Exception {
	public WrongCredentialsException(String str) {
		super(str);
	}
}
