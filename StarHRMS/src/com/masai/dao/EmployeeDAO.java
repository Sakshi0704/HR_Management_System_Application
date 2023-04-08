package com.masai.dao;

import java.time.LocalDate;
import java.util.List;

import com.masai.dto.EmployeeDTO;
import com.masai.dto.LeaveDTO;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

public interface EmployeeDAO {

	public List<String> empLogIn(String emailId, String password) throws WrongCredentialsException, SomthingWentWrongException;

	public EmployeeDTO viewYourProfile(int empId) throws NoSuchRecordFoundException, SomthingWentWrongException;

	public void changePassword(String password,String updatedPassword, int empId) throws NoSuchRecordFoundException,SomthingWentWrongException;

	public void applyForLeave(LeaveDTO leave ,int empId) throws SomthingWentWrongException;

	public LeaveDTO leaveStatus(int empId) throws SomthingWentWrongException, NoSuchRecordFoundException;

	public List<LeaveDTO> recordOfLeave(int empId) throws SomthingWentWrongException, NoSuchRecordFoundException;

	public double totalSalaryOfMonth(int empId) throws SomthingWentWrongException;

	public double totalSalaryAnnualy(int empId) throws SomthingWentWrongException;

	
	
	
	
}
