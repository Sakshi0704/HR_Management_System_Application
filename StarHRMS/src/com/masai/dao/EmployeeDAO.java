package com.masai.dao;


import java.util.List;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.LeaveDTO;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

/**
 * Data Access Object (DAO) interface for Employee entities. The EmployeeDAO
 * interface provides methods to access and manipulate employee-related data in
 * the database.
 * 
 * @author Km Sakshi
 */
public interface EmployeeDAO {

	/**
	 * Authenticates an employee by their email ID and password.
	 *
	 * @param emailId  the email ID of the employee
	 * @param password the password of the employee
	 * 
	 * @return a list of employee roles if the credentials are valid
	 * 
	 * @throws WrongCredentialsException  if the provided credentials are incorrect
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	public List<String> empLogIn(String emailId, String password)
			throws WrongCredentialsException, SomthingWentWrongException;

	/**
	 * Retrieves the profile information of an employee.
	 *
	 * @param empId the ID of the employee
	 * 
	 * @return the EmployeeDTO containing the profile information
	 * 
	 * @throws NoSuchRecordFoundException if the employee record does not exist
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	public EmployeeDTO viewYourProfile(int empId) throws NoSuchRecordFoundException, SomthingWentWrongException;

	/**
	 * Changes the password of an employee.
	 *
	 * @param password        the current password of the employee
	 * @param updatedPassword the new password to set
	 * @param empId           the ID of the employee
	 * 
	 * @throws NoSuchRecordFoundException if the employee record does not exist
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	public void changePassword(String password, String updatedPassword, int empId)
			throws NoSuchRecordFoundException, SomthingWentWrongException;

	/**
	 * Applies for leave for an employee.
	 *
	 * @param leave the LeaveDTO containing the leave details
	 * @param empId the ID of the employee
	 * 
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	public void applyForLeave(LeaveDTO leave, int empId) throws SomthingWentWrongException;

	/**
	 * Retrieves the leave status of an employee.
	 *
	 * @param empId the ID of the employee
	 * 
	 * @return the LeaveDTO containing the leave status
	 * 
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 * @throws NoSuchRecordFoundException if the employee record does not exist
	 */
	public LeaveDTO leaveStatus(int empId) throws SomthingWentWrongException, NoSuchRecordFoundException;

	/**
	 * Retrieves the record of leaves for an employee.
	 *
	 * @param empId the ID of the employee
	 * 
	 * @return a list of LeaveDTO objects representing the leave records
	 * 
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 * @throws NoSuchRecordFoundException if the employee record does not exist
	 */
	public List<LeaveDTO> recordOfLeave(int empId) throws SomthingWentWrongException, NoSuchRecordFoundException;

	/**
	 * Calculates the total salary of an employee for the current month.
	 *
	 * @param empId the ID of the employee
	 * 
	 * @return the total salary for the current month
	 * 
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	public double totalSalaryOfMonth(int empId) throws SomthingWentWrongException;

	/**
	 * Calculates the total annual salary of an employee.
	 *
	 * @param empId the ID of the employee
	 * 
	 * @return the total annual salary
	 */
	public double totalSalaryAnnualy(int empId) throws SomthingWentWrongException;

}
