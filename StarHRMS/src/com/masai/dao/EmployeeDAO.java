package com.masai.dao;

import java.util.List;

import com.masai.dto.EmployeeDTO;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

public interface EmployeeDAO {

	public List<String> empLogIn(String emailId, String password) throws WrongCredentialsException, SomthingWentWrongException;

	public List<EmployeeDTO> viewYourProfile(int empId) throws NoSuchRecordFoundException, SomthingWentWrongException;

	public void changePassword(String password,String updatedPassword, int empId) throws NoSuchRecordFoundException,SomthingWentWrongException;

	public List<EmployeeDTO> viewAllEmployee() throws NoSuchRecordFoundException, SomthingWentWrongException;
	
	
	
}
