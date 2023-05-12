package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.masai.dto.DepartmentDTOImpl;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.EmployeeDTOImpl;
import com.masai.dto.LeaveDTO;
import com.masai.dto.LeaveDTOImpl;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

/**
 * The EmployeeDAOImpl class is an implementation of the EmployeeDAO interface.
 * It provides the actual implementation for accessing and manipulating
 * employee-related data in the database. This class interacts with the database
 * to perform CRUD (Create, Read, Update, Delete) operations on employee
 * records.
 * 
 * @author Km Sakshi
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	/**
	 * Authenticates an employee by their email ID and password.
	 *
	 * @param emailId  The email ID of the employee.
	 * @param password The password of the employee.
	 * 
	 * @return A list of employee roles if the credentials are valid.
	 * 
	 * @throws WrongCredentialsException  If the provided credentials are incorrect.
	 * @throws SomthingWentWrongException If an unexpected error occurs.
	 */
	@Override
	public List<String> empLogIn(String emailId, String password)
			throws WrongCredentialsException, SomthingWentWrongException {

		Connection conn = null;
		List<String> list = new ArrayList<>();
		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Prepare the SQL query to select employee ID and name based on email and
			// password
			String query = "select eId,ename from Employee where email=? && password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, emailId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new WrongCredentialsException("Wrong Login Credentials");
			}

			// Retrieve employee details from the result set and add them to the list
			while (rs.next()) {
				list.add(rs.getInt(1) + ""); // Add employee ID
				list.add(rs.getString(2)); // Add employee name
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
	 * Retrieves the profile information of an employee by their employee ID.
	 *
	 * @param empId the employee ID
	 * 
	 * @return an EmployeeDTO object containing the profile information
	 * 
	 * @throws NoSuchRecordFoundException if no record is found for the provided
	 *                                    employee ID
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	@Override
	public EmployeeDTO viewYourProfile(int empId) throws NoSuchRecordFoundException, SomthingWentWrongException {

		Connection conn = null;
		EmployeeDTO employee = null;
		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();
			// need to work.................................//

			// Prepare the SQL query to select the employee profile information with the
			// given employee ID
			String query = "select e.empId,e.ename,e.email,e.empAddress,e.Salary_Per_Month,e.date_of_joining,"
					+ "d.deptID,d.deptName from Employee e INNER JOIN dept d ON (d.did = e.did AND e.eId = ? AND e.is_delete = 0)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new NoSuchRecordFoundException("There is no such record avaiable");
			}

			// Retrieve the employee profile information from the result set and create an
			// EmployeeDTO object
			if (rs.next()) {
				employee = new EmployeeDTOImpl(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						"xxxxxxx", rs.getDouble(5), rs.getDate(6).toLocalDate(),
						new DepartmentDTOImpl(rs.getString(7), rs.getString(8)));
				return employee;
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

		return employee;

	}

	/**
	 * Changes the password of an employee.
	 *
	 * @param oldPassword     the current password of the employee
	 * @param updatedPassword the new password to be set
	 * @param empId           the employee ID
	 * 
	 * @throws NoSuchRecordFoundException if no record is found for the provided
	 *                                    employee ID or the old password is
	 *                                    incorrect
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	@Override
	public void changePassword(String oldPassword, String updatedPassword, int empId)
			throws NoSuchRecordFoundException, SomthingWentWrongException {
		Connection conn = null;
		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Prepare the SQL query to update the employee password
			String query = "update employee set password = ? where password = ? AND eId = ? AND is_delete = 0";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, updatedPassword);
			ps.setString(2, oldPassword);
			ps.setInt(3, empId);

			// Execute the update query
			int rs = ps.executeUpdate();

			// Check if any rows were affected by the update
			if (rs == 0) {
				throw new NoSuchRecordFoundException("Invalid Input");
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

	}

	/**
	 * Applies for a leave for a given employee.
	 *
	 * @param leave the leave details
	 * @param empId the employee ID
	 * 
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	@Override
	public void applyForLeave(LeaveDTO leave, int empId) throws SomthingWentWrongException {

		Connection conn = null;
		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Prepare the SQL query to insert a new leave record
			String query = "insert into empleave" + "(days_of_leave,type,reason,eid,date_of_leave)" + "values"
					+ "(?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, leave.getDays_of_leave());
			ps.setInt(2, leave.getType());
			ps.setString(3, leave.getReason());
			ps.setInt(4, empId);
			ps.setDate(5, Date.valueOf(LocalDate.now()));

			// Execute the insert query
			int n = ps.executeUpdate();

			// Check if any rows were affected by the insert
			if (n == 0) {
				throw new SomthingWentWrongException("Unable to add Input is Wrong");
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

	}

	/**
	 * Retrieves the leave status for a given employee.
	 *
	 * @param empId the employee ID
	 * 
	 * @return the leave details for the employee
	 * 
	 * @throws NoSuchRecordFoundException if no record is found for the employee
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	@Override
	public LeaveDTO leaveStatus(int empId) throws SomthingWentWrongException, NoSuchRecordFoundException {

		Connection conn = null;
		LeaveDTO empLeave = null;
		try {
			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Prepare the SQL query to retrieve the leave status for the employee
			String query = "select days_of_leave,type,reason,date_of_leave,status,e.empId,e.ename "
					+ "from empleave el LEfT JOIN employee e ON el.eId = e.eId where e.eId = ? "
					+ "order by date_of_leave desc limit 1";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new NoSuchRecordFoundException("There is no record avaiable for you");
			}

			// Retrieve the leave details from the result set
			while (rs.next()) {
				empLeave = new LeaveDTOImpl(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4).toLocalDate(),
						rs.getString(5), rs.getString(6), rs.getString(7));
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

		return empLeave;

	}

	/**
	 * Retrieves the record of leave for a given employee.
	 *
	 * @param empId the employee ID
	 * 
	 * @return the list of leave records for the employee
	 * 
	 * @throws NoSuchRecordFoundException if no record is found for the employee
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	@Override
	public List<LeaveDTO> recordOfLeave(int empId) throws SomthingWentWrongException, NoSuchRecordFoundException {
		Connection conn = null;
		List<LeaveDTO> list = new ArrayList<>();
		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Prepare the SQL query to retrieve the record of leave for the employee
			String query = "select days_of_leave,type,reason,date_of_leave,status,e.empId,e.ename "
					+ "from empleave el LEfT JOIN employee e ON el.eId = e.eId WHERE e.eId = ? AND el.status = 'Accept'"
					+ "order by date_of_leave desc limit 3";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new NoSuchRecordFoundException("There is no record avaiable");
			}

			// Retrieve the leave records from the result set
			while (rs.next()) {
				// Catch any SQL or class loading exceptions and wrap them in a custom exception
				list.add(new LeaveDTOImpl(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4).toLocalDate(),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// Close the database connection
			throw new SomthingWentWrongException(e.getMessage());
		} finally {
			try {
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * Calculates the total salary for the month based on the employee's leave
	 * count.
	 *
	 * @param empId the employee ID
	 * 
	 * @return the total salary for the month
	 * 
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	@Override
	public double totalSalaryOfMonth(int empId) throws SomthingWentWrongException {

		Connection conn = null;
		double salary = 0;
		int total_leave = 0;
		try {
			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();
			// need to work.................................//

			// Prepare the SQL query to count the accepted leave for the employee
			String query = "select count(*) from empleave where eId = ? AND status = 'Accepted' AND type = 3";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new SomthingWentWrongException("No Leave have taken");
			}

			// Retrieve the total leave count
			while (rs.next()) {
				total_leave = rs.getInt(1);
			}

			// Calculate the salary for the month
			PreparedStatement ps2 = conn.prepareStatement(
					"select round(Salary_Per_Month-(Salary_Per_Month/30*?) , 2) from employee where eId = ?");
			ps2.setInt(1, total_leave);
			ps2.setInt(2, empId);
			ResultSet rs2 = ps2.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs2)) {
				throw new SomthingWentWrongException(" Something went Wrong !! please try after some time ");
			}

			// Retrieve the total salary for the month
			while (rs2.next()) {
				salary = rs2.getDouble(1);
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
		return salary;
	}

	/**
	 * Calculates the total salary for the year based on the employee's monthly
	 * salary.
	 *
	 * @param empId the employee ID
	 * 
	 * @return the total salary for the year
	 * 
	 * @throws SomthingWentWrongException if an unexpected error occurs
	 */
	@Override
	public double totalSalaryAnnualy(int empId) throws SomthingWentWrongException {

		Connection conn = null;
		double salary = 0;
		try {

			// Establish a connection to the database
			conn = DBUtility.getConnectionToDataBase();

			// Prepare the SQL query to retrieve the monthly salary and calculate the annual
			// salary
			PreparedStatement ps = conn
					.prepareStatement("select round((salary_per_Month*12),2) from employee where eid=?");

			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			// Check if the result set is empty
			if (DBUtility.isResultSetEmpty(rs)) {
				throw new SomthingWentWrongException("Something went Wrong !! please try after some time");
			}

			// Retrieve the annual salary
			while (rs.next()) {
				salary = rs.getDouble(1);
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Catch any SQL or class loading exceptions and wrap them in a custom exception
			throw new SomthingWentWrongException(ex.getMessage());
		} finally {
			try {
				// Close the database connection
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return salary;
	}

}
