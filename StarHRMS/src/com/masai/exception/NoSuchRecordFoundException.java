package com.masai.exception;

/**
 * Custom exception class for handling cases where a requested record is not
 * found. This exception is thrown when a specific record is not found in the
 * system or database. It extends the Exception class and provides a custom
 * constructor to set an error message.
 * 
 * @author Km Sakshi
 */
public class NoSuchRecordFoundException extends Exception {
	public NoSuchRecordFoundException(String str) {
		super(str);
	}
}
