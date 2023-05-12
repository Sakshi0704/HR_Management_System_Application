package com.masai.dto;

import java.time.LocalDate;

/**
 * The LeaveDTO interface represents a data transfer object for employee leaves.
 * It provides methods to get and set various attributes of a leave.
 * 
 * @author Km Sakshi
 */
public interface LeaveDTO {

	/**
	 * Gets the number of days for the leave.
	 * 
	 * @return the number of days for the leave
	 */
	public int getDays_of_leave();

	/**
	 * Sets the number of days for the leave.
	 * 
	 * @param days_of_leave the number of days for the leave to set
	 */
	public void setDays_of_leave(int days_of_leave);

	/**
	 * Gets the type of the leave.
	 * 
	 * @return the type of the leave
	 */
	public int getType();

	/**
	 * Sets the type of the leave.
	 * 
	 * @param type the type of the leave to set
	 */
	public void setType(int type);

	/**
	 * Gets the type of the leave in words.
	 * 
	 * @return the type of the leave in words
	 */
	public String getTypeInWords();

	/**
	 * Gets the reason for the leave.
	 * 
	 * @return the reason for the leave
	 */
	public String getReason();

	/**
	 * Sets the reason for the leave.
	 * 
	 * @param reason the reason for the leave to set
	 */
	public void setReason(String reason);

	/**
	 * Gets the date of the leave.
	 * 
	 * @return the date of the leave
	 */
	public LocalDate getDate();

	/**
	 * Sets the date of the leave.
	 * 
	 * @param date the date of the leave to set
	 */
	public void setDate(LocalDate date);

	/**
	 * Gets the status of the leave.
	 * 
	 * @return the status of the leave
	 */
	public String getStatus();

	/**
	 * Sets the status of the leave.
	 * 
	 * @param status the status of the leave to set
	 */
	public void setStatus(String status);

	/**
	 * Gets the leave ID.
	 * 
	 * @return the leave ID
	 */
	public int getLeaveId();

	/**
	 * Sets the leave ID.
	 * 
	 * @param leaveId the leave ID to set
	 */
	public void setLeaveId(int leaveId);

	/**
	 * Gets the employee ID associated with the leave.
	 * 
	 * @return the employee ID associated with the leave
	 */
	public String getEmpId();

	/**
	 * Sets the employee ID associated with the leave.
	 * 
	 * @param empId the employee ID to set
	 */
	public void setEmpId(String empId);

	/**
	 * Gets the employee name associated with the leave.
	 * 
	 * @return the employee name associated with the leave
	 */
	public String getEmpName();

	/**
	 * Sets the employee name associated with the leave.
	 * 
	 * @param empName the employee name to set
	 */
	public void setEmpName(String empName);

	/**
	 * Returns the string representation of the LeaveDTO object.
	 * 
	 * @return the string representation of the LeaveDTO object
	 */
	String toString1();

}
