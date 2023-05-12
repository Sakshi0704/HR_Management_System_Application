package com.masai.dao;

import java.util.List;
import java.util.Map;
import com.masai.dto.DepartmentDTO;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.LeaveDTO;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;

/**
 * The interface representing the data access object (DAO) for administrative
 * operations. This interface provides methods for managing departments,
 * employees, leave requests, and related operations.
 * 
 * @author Km Sakshi
 */
public interface AdminDAO {

	/**
	 * Adds a new department to the database.
	 *
	 * @param deptId   the ID of the new department.
	 * @param deptName the name of the new department.
	 * 
	 * @throws SomethingWentWrongException if there is an error adding the
	 *                                     department to the database.
	 */
	void addNewDepartment(String deptId, String deptName) throws SomthingWentWrongException;

	/**
	 * Returns a list of all departments in the database.
	 *
	 * @return a list of all departments in the database.
	 * 
	 * @throws SomethingWentWrongException if there is an error retrieving the
	 *                                     departments from the database.
	 * 
	 * @throws NoSuchRecordFoundException  if there are no departments in the
	 *                                     database.
	 */
	List<DepartmentDTO> viewAllDepartment() throws SomthingWentWrongException, NoSuchRecordFoundException;

	/**
	 * Updates the details of a department in the database.
	 *
	 * @param oldDeptID the ID of the department to be updated.
	 * @param deptId    the new ID of the department.
	 * @param deptName  the new name of the department.
	 * 
	 * @throws SomethingWentWrongException if there is an error updating the
	 *                                     department in the database.
	 * @throws NoSuchRecordFoundException  if the department with the given ID does
	 *                                     not exist in the database.
	 */
	void updateDepartmentAllDetails(String oldDeptID, String deptId, String deptName)
			throws SomthingWentWrongException, NoSuchRecordFoundException;

	/**
	 * Returns a list of all employees in the database.
	 *
	 * @return a list of all employees in the database.
	 * 
	 * @throws NoSuchRecordFoundException  if there are no employees in the
	 *                                     database.
	 * @throws SomethingWentWrongException if there is an error retrieving the
	 *                                     employees from the database.
	 */
	public List<EmployeeDTO> viewAllEmployee() throws NoSuchRecordFoundException, SomthingWentWrongException;

	/**
	 * Adds a new employee to the database and assigns them to a department.
	 *
	 * @param employee the new employee to add to the database.
	 * @param deptID   the ID of the department to which the employee should be
	 *                 assigned.
	 * 
	 * @throws SomethingWentWrongException if there is an error adding the employee
	 *                                     to the database.
	 */
	void addNewEmployee(EmployeeDTO employee, String deptID) throws SomthingWentWrongException;

	/**
	 * Deletes a department from the database.
	 *
	 * @param deptID the ID of the department to delete.
	 * 
	 * @throws SomethingWentWrongException if there is an error deleting the
	 *                                     department from the database.
	 */
	void deleteDepartment(String deptID) throws SomthingWentWrongException;

	/**
	 * Transfers an employee to a different department in the database.
	 *
	 * @param empId  the ID of the employee to transfer.
	 * @param deptID the ID of the department to which the employee should be
	 *               transferred.
	 * 
	 * @throws SomethingWentWrongException if there is an error transferring the
	 *                                     employee to the new department.
	 */
	void transferemployeetootherdepart(String empId, String deptID) throws SomthingWentWrongException;

	/**
	 * Removes an employee from the database.
	 *
	 * @param empId the ID of the employee to remove.
	 * 
	 * @throws SomethingWentWrongException if there is an error removing the
	 *                                     employee from the database.
	 */
	void fireEmployee(String empId) throws SomthingWentWrongException;

	/**
	 * Returns a map of all leave requests in the database.
	 *
	 * @return a map of leave requests, where the keys are the leave IDs and the
	 *         values are the corresponding LeaveDTO objects.
	 * 
	 * @throws SomethingWentWrongException if there is an error retrieving the leave
	 *                                     requests from the database.
	 */
	Map<Integer, LeaveDTO> getListOfLeaveRequst() throws SomthingWentWrongException;

	/**
	 * Accepts a leave request for an employee.
	 *
	 * @param leaveId the ID of the leave request to accept.
	 * 
	 * @throws SomethingWentWrongException if there is an error accepting the leave
	 *                                     request in the database.
	 */
	void acceptLeaveOfEmployee(int leaveId) throws SomthingWentWrongException;

	/**
	 * Rejects a leave request for an employee.
	 *
	 * @param leaveId the ID of the leave request to reject.
	 * 
	 * @throws SomethingWentWrongException if there is an error rejecting the leave
	 *                                     request in the database.
	 */
	void rejectLeaveOfEmployee(int leaveId) throws SomthingWentWrongException;

}