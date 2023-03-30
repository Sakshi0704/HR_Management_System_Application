package com.masai.dao;

import java.util.List;

import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

public interface EmployeeDAO {

	public List<String> empLogIn(String emailId, String password) throws WrongCredentialsException, SomthingWentWrongException;
	
	
	
}
