package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.masai.dto.DepartmentDTO;
import com.masai.dto.DepartmentDTOImpl;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.EmployeeDTOImpl;
import com.masai.dto.LeaveDTO;
import com.masai.dto.LeaveDTOImpl;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;
import com.masai.validation.EmailValidation;

/**
 * Implementation of the AdminDAO interface that provides the functionality to
 * perform administrative operations.
 * 
 * This class interacts with the underlying data source to add, update,
 * retrieve, and delete departments, employees, and leave requests.
 * 
 * @author Km Sakshi
 */
public class AdminDAOImpl implements AdminDAO {

	
	// Create an instance of the EmailValidation class for email address validation
	EmailValidation emailValidation = new EmailValidation();
	
	
	
	/**
	 * Adds a new department to the database.
	 *
	 * @param deptId   the ID of the new department.
	 * @param deptName the name of the new department.
	 * 
	 * @throws SomethingWentWrongException if there is an error adding the
	 *                                     department to the database.
	 */
	@Override
	public void addNewDepartment(String deptId, String deptName) throws SomthingWentWrongException {

		Connection conn = null;

		try {
			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Prepare the SQL query to insert a new department
			String query = "insert into dept (deptID,deptName) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, deptId);
			ps.setString(2, deptName);

			// Execute the update query
			int i = ps.executeUpdate();

			// Check if any rows were affected by the update
			if (i == 0) {
				throw new SomthingWentWrongException("Please Provide the Correct Details");
			}

		} catch (SQLException | ClassNotFoundException ex) {

			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException(ex.getMessage());

		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}
	}

	
	
	
	/**
	 * Returns a list of all departments in the database.
	 *
	 * @return a list of all departments retrieved from the database.
	 * 
	 * @throws SomethingWentWrongException if there is an error retrieving the
	 *                                     departments from the database.
	 * @throws NoSuchRecordFoundException  if there are no departments in the
	 *                                     database.
	 */
	@Override
	public List<DepartmentDTO> viewAllDepartment() throws SomthingWentWrongException, NoSuchRecordFoundException {

		Connection conn = null;
		List<DepartmentDTO> list = null;

		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Prepare the SQL query to select all departments
			String query = "select deptID , deptName from dept  where is_delete = 0";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new NoSuchRecordFoundException("There is no record to review");
			}

			// Iterate over the result set and populate the department list
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new DepartmentDTOImpl(rs.getString(1), rs.getString(2)));
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException("Unable to get data please try again leter");
		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return list;
	}

	
	
	
	/**
	 * Updates all details of a department in the database.
	 *
	 * @param oldDeptID the current ID of the department to be updated.
	 * @param deptId    the new ID of the department.
	 * @param deptName  the new name of the department.
	 * 
	 * @throws SomethingWentWrongException if there is an error updating the
	 *                                     department details in the database.
	 * @throws NoSuchRecordFoundException  if the current department ID does not
	 *                                     exist in the database.
	 */
	@Override
	public void updateDepartmentAllDetails(String oldDeptID, String deptId, String deptName)
			throws SomthingWentWrongException, NoSuchRecordFoundException {

		Connection conn = null;
		int did = 0;
		try {
			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Check if the current department ID exists and is not marked for deletion
			String query = "select did from dept where deptID = ? AND is_delete = 0";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, oldDeptID);

			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new SomthingWentWrongException("Currect DeptID is invalid ! please check ");
			}

			// Retrieve the department ID
			while (rs.next()) {
				did = rs.getInt(1);
			}

			// Update the department details
			query = "Update dept set deptID = ? , deptName = ? where did = ? AND is_delete = 0";

			ps = conn.prepareStatement(query);
			ps.setString(1, deptId);
			ps.setString(2, deptName);
			ps.setInt(3, did);

			// Execute the update query
			int i = ps.executeUpdate();

			// Check if any rows were affected by the update
			if (i == 0) {
				throw new NoSuchRecordFoundException("No Such Updated Dept Id avaiable");
			}

		} catch (SomthingWentWrongException | NoSuchRecordFoundException | SQLException | ClassNotFoundException ex) {

			// Catch any custom exceptions or SQL/class loading exceptions and wrap them in
			// a custom exception
			throw new SomthingWentWrongException(ex.getMessage());

		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}
	}

	
	
	
	
	/**
	 * Retrieves a list of all employees from the database.
	 *
	 * @return a list of all employees retrieved from the database.
	 * 
	 * @throws NoSuchRecordFoundException  if there are no records of employees in
	 *                                     the database.
	 * @throws SomethingWentWrongException if there is an error retrieving the
	 *                                     employee data from the database.
	 */
	@Override
	public List<EmployeeDTO> viewAllEmployee() throws NoSuchRecordFoundException, SomthingWentWrongException {
		Connection conn = null;
		List<EmployeeDTO> list = new ArrayList<>();
		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Prepare the SQL query to retrieve all employees with their department details
			String query = "select e.empId,e.ename,e.email,e.empAddress,e.Salary_Per_Month,e.date_of_joining,d.deptID,"
					+ "d.deptName from Employee e INNER JOIN Dept d  ON e.did = d.did AND e.is_delete = 0";

			PreparedStatement ps = conn.prepareStatement(query);

			// Execute the query and retrieve the result set
			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new NoSuchRecordFoundException("There is no such record avaiable");
			}

			// Iterate over the result set and populate the employee list
			while (rs.next()) {
				list.add(new EmployeeDTOImpl(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						"xxxxxxx", rs.getDouble(5), rs.getDate(6).toLocalDate(),
						new DepartmentDTOImpl(rs.getString(7), rs.getString(8))));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException(e.getMessage());
		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	
	
	
	/**
	 * Adds a new employee to the database.
	 *
	 * @param employee the EmployeeDTO object containing the details of the employee
	 *                 to be added.
	 * @param deptID   the ID of the department to which the employee belongs.
	 * 
	 * @throws SomethingWentWrongException if there is an error adding the employee
	 *                                     to the database.
	 */
	@Override
	public void addNewEmployee(EmployeeDTO employee, String deptID) throws SomthingWentWrongException {

		Connection conn = null;
		int did = 0;
		try {
			
			// Validate the email address of the employee using the emailValidation instance
			if(!emailValidation.emailValidation(employee.getEmail())){
				
				// If the email address is invalid, throw an exception indicating the issue
				throw new SomthingWentWrongException("Wrong email address please provide valid email address");
				
				
			}
			
			
			
			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Check if the department ID exists and is not marked for deletion
			String query = "select did from dept where deptID = ? AND is_delete = 0";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, deptID);
			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new SomthingWentWrongException("Wrong DeptID!! Please Check The Department ID");
			}

			// Retrieve the department ID
			while (rs.next()) {
				did = rs.getInt(1);
			}

			// Insert the new employee into the database
			query = "insert into employee (empId,ename,email,empAddress,date_of_joining,salary_per_month,did) values (?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(query);
			ps.setString(1, employee.getEmpId());
			ps.setString(2, employee.getEname());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getEmpAddress());
			ps.setDate(5, java.sql.Date.valueOf(employee.getDate()));
			ps.setDouble(6, employee.getSalary());
			ps.setInt(7, did);

			// Execute the insert query
			int i = ps.executeUpdate();

			// Check if any rows were affected by the insert
			if (i == 0) {

				throw new SomthingWentWrongException(
						"Wrong Inputs !! \n\tPlease check details properly before add any employee \n\t Thank You");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException(ex.getMessage());

		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	
	
	
	
	/**
	 * Deletes a department from the database.
	 *
	 * @param deptID the ID of the department to be deleted.
	 * 
	 * @throws SomethingWentWrongException if there is an error deleting the
	 *                                     department from the database.
	 */
	@Override
	public void deleteDepartment(String deptID) throws SomthingWentWrongException {

		Connection conn = null;
		int did = 0;

		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Check if the department ID exists
			String query = "select did from dept where deptID = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, deptID);

			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new SomthingWentWrongException("Wrong Department Id ");
			}

			// Retrieve the department ID
			while (rs.next()) {
				did = rs.getInt(1);
			}

			// Mark the department as deleted in the database
			query = "update dept set is_delete = 1 where did = ? AND did != 1 AND is_delete = 0";
			ps = conn.prepareStatement(query);

			ps.setInt(1, did);
			int n = ps.executeUpdate();

			// Check if any rows were affected by the update
			if (n == 0) {
				throw new SomthingWentWrongException("No Record Found To Delete");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException(ex.getMessage());

		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	
	
	
	/**
	 * Transfers an employee to another department.
	 *
	 * @param empId  the ID of the employee to be transferred.
	 * @param deptID the ID of the department to which the employee will be
	 *               transferred.
	 * 
	 * @throws SomethingWentWrongException if there is an error transferring the
	 *                                     employee to another department.
	 */
	@Override
	public void transferemployeetootherdepart(String empId, String deptID) throws SomthingWentWrongException {

		Connection conn = null;
		int did = 0;
		int eId = 0;

		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Check if the department ID exists
			String query = "select did from dept where deptID = ? AND is_delete = 0";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, deptID);

			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new SomthingWentWrongException(
						"Wrong Department Id To Transfer. There is no such Department avaiable");
			}

			// Retrieve the department ID
			while (rs.next()) {
				did = rs.getInt(1);
			}

			// Check if the employee ID exists
			query = "select eId from employee where empId = ?";
			ps = conn.prepareStatement(query);

			ps.setString(1, empId);

			rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new SomthingWentWrongException("Wrong Employee Id ! Please Check The Employee Id ");
			}

			// Retrieve the employee ID
			while (rs.next()) {
				eId = rs.getInt(1);
			}

			// Update the employee's department in the database
			query = "update employee set did = ? where eId = ? AND is_delete = 0";
			ps = conn.prepareStatement(query);

			ps.setInt(1, did);
			ps.setInt(2, eId);

			int n = ps.executeUpdate();

			// Check if any rows were affected by the update
			if (n == 0) {
				throw new SomthingWentWrongException(
						"The employee doesn't belong to our organisation. Or Fired employee");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException(ex.getMessage());

		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	
	
	
	/**
	 * Fires an employee by marking them as deleted in the database.
	 *
	 * @param empId the ID of the employee to be fired.
	 * 
	 * @throws SomethingWentWrongException if there is an error firing the employee.
	 */
	@Override
	public void fireEmployee(String empId) throws SomthingWentWrongException {
		Connection conn = null;
		int eId = 0;

		try {
			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Check if the employee ID exists
			String query = "select eId from employee where empId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, empId);

			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new SomthingWentWrongException("Wrong Employee Id ");
			}

			// Retrieve the employee ID
			while (rs.next()) {
				eId = rs.getInt(1);
			}

			// Mark the employee as deleted in the database
			query = "update employee set is_delete = 1 where eId = ? And is_delete = 0";
			ps = conn.prepareStatement(query);

			ps.setInt(1, eId);

			int n = ps.executeUpdate();

			// Check if any rows were affected by the update
			if (n == 0) {
				throw new SomthingWentWrongException("No Record Found To Fire The Employee");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException(ex.getMessage());

		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	
	
	
	/**
	 * Retrieves a list of pending leave requests from the database.
	 *
	 * @return a map of leave request IDs to LeaveDTO objects representing the leave
	 *         requests.
	 * 
	 * @throws SomethingWentWrongException if there is an error retrieving the leave
	 *                                     requests.
	 */
	@Override
	public Map<Integer, LeaveDTO> getListOfLeaveRequst() throws SomthingWentWrongException {
		// select leaveId,days_of_leave,type,reason,date_of_leave,status,e.empId,e.ename
		// from empleave el LEfT JOIN employee e ON el.eId = e.eId AND status =
		// 'panding' order by date_of_leave desc limit 1;
		Connection conn = null;
		Map<Integer, LeaveDTO> map = null;
		try {
			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Retrieve the list of pending leave requests
			String query = "select leaveId,days_of_leave,type,reason,date_of_leave,status,e.empId,e.ename "
					+ "from empleave el LEfT JOIN employee e"
					+ " ON el.eId = e.eId where el.status = 'panding' order by date_of_leave desc";

			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new SomthingWentWrongException("No Leave Request is panding");
			}

			// Create a LinkedHashMap to store the leave requests
			map = new LinkedHashMap<>();

			// Iterate over the result set and populate the map with LeaveDTO objects
			while (rs.next()) {
				map.put(rs.getInt(1), new LeaveDTOImpl(rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getDate(5).toLocalDate(), rs.getString(6), rs.getString(7), rs.getString(8)));
			}

		} catch (SQLException | ClassNotFoundException ex) {
			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException(ex.getMessage());

		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

		return map;
	}

	
	
	
	/**
	 * Accepts a leave request of an employee by updating its status in the
	 * database.
	 *
	 * @param leaveId the ID of the leave request to accept
	 * 
	 * @throws SomethingWentWrongException if there is an error accepting the leave
	 *                                     request
	 */
	@Override
	public void acceptLeaveOfEmployee(int leaveId) throws SomthingWentWrongException {

		Connection conn = null;
		try {
			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Update the status of the leave request to 'Accept' in the database
			String query = "update empleave set status = 'Accept',is_removed = 1 where leaveId = ? AND status = 'panding' AND is_removed = 0";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, leaveId);

			int i = ps.executeUpdate();

			// Check if the update was successful
			if (i == 0) {
				throw new SomthingWentWrongException("Something went wrong ! please try again");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException(ex.getMessage());

		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	
	
	
	/**
	 * Rejects a leave request of an employee by updating its status in the
	 * database.
	 *
	 * @param leaveId the ID of the leave request to reject
	 * 
	 * @throws SomethingWentWrongException if there is an error rejecting the leave
	 *                                     request
	 */
	@Override
	public void rejectLeaveOfEmployee(int leaveId) throws SomthingWentWrongException {
		Connection conn = null;
		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Update the status of the leave request to 'Reject' in the database
			String query = "update empleave set status = 'Reject',is_removed = 1 where leaveId = ? AND status = 'panding' AND is_removed = 0";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, leaveId);

			int i = ps.executeUpdate();

			// Check if the update was successful
			if (i == 0) {
				// Catch any SQL or class loading exceptions and wrap them in a custom exception
				throw new SomthingWentWrongException("Something went wrong ! please try again letter");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			throw new SomthingWentWrongException(ex.getMessage());

		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}
}