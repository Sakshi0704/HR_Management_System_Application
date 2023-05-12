package com.masai.exception;


/**
* Custom exception class for handling unexpected errors.
* This exception is thrown when something unexpected goes wrong in the program.
* It extends the Exception class and provides a custom constructor to set an error message.
*
* @author Km Sakshi
*/
public class SomthingWentWrongException extends Exception {
	public SomthingWentWrongException(String str) {
		super(str);
	}
}
