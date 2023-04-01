package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.DepartmentDTO;
import com.masai.dto.DepartmentDTOImpl;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.EmployeeDTOImpl;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Override
	public List<String> empLogIn(String emailId, String password) throws WrongCredentialsException, SomthingWentWrongException {
		// get connection to database....
		Connection conn = null;
		List<String> list = new ArrayList<>();
		try {
			conn = DBUtility.getConnectionToDataBase();
			
			String query = "select eId,ename from Employee where email=? && password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, emailId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(DBUtility.isResultSetEmpty(rs)) {
				throw new WrongCredentialsException("Wrong Login Credentials");
			}
		  while(rs.next()) {
			  list.add(rs.getInt(1)+"");
			  list.add(rs.getString(2));
		  }
			
		} catch (ClassNotFoundException |SQLException e) {
			//throw new SomthingWentWrongException("Unable to connection with database! please try again");
			throw new SomthingWentWrongException(e.getMessage());
		}finally{
			try {
				DBUtility.closeConnectionToDataBase(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	   return list;
	}

	@Override
	public List<EmployeeDTO> viewYourProfile(int empId) throws NoSuchRecordFoundException, SomthingWentWrongException {
		
		// get connection to database....
		   Connection conn = null;
		   List<EmployeeDTO> list = new ArrayList<>();  
		   try {
				conn = DBUtility.getConnectionToDataBase();
				// need to work.................................//
				String query = "select e.empId,e.ename,e.email,e.empAddress,e.Salary_Per_Month,e.date_of_joining,"
						+ "d.deptID,d.deptName from Employee e INNER JOIN dept d ON (d.did = e.did AND e.eId = ? AND is_delete = 0)";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, empId);
				ResultSet rs = ps.executeQuery();
				if(DBUtility.isResultSetEmpty(rs)) {
					throw new NoSuchRecordFoundException("There is no such record avaiable");
				}
			  while(rs.next()) {
				  list.add(new EmployeeDTOImpl(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),"xxxxxxx",rs.getDouble(5),
						  		rs.getDate(6).toLocalDate(), new DepartmentDTOImpl(rs.getString(7),rs.getString(8))));
			  }
				
			} catch (ClassNotFoundException |SQLException e) {
				//throw new SomthingWentWrongException("Unable to connection with database! please try again");
				throw new SomthingWentWrongException(e.getMessage());
			}finally{
				try {
					DBUtility.closeConnectionToDataBase(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		  
		   return list;
		
	}

	@Override
	public void changePassword(String oldPassword,String updatedPassword, int empId)
			throws NoSuchRecordFoundException, SomthingWentWrongException {
			Connection conn = null;
		   List<EmployeeDTO> list = new ArrayList<>();  
		   try {
				conn = DBUtility.getConnectionToDataBase();
				
				String query = "update employee set password = ? where (password = ? & eId = ?) AND is_delete = 0";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, oldPassword);
				ps.setString(2, updatedPassword);
				ps.setInt(3,empId);
				
				ResultSet rs = ps.executeQuery();
				if(DBUtility.isResultSetEmpty(rs)) {
					throw new NoSuchRecordFoundException("Invalid Details");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				//throw new SomthingWentWrongException("Unable to connection with database! please try again");
				throw new SomthingWentWrongException(e.getMessage());
			}finally{
				try {
					DBUtility.closeConnectionToDataBase(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}

	@Override
	public List<EmployeeDTO> viewAllEmployee() throws NoSuchRecordFoundException, SomthingWentWrongException {
		Connection conn = null;
		   List<EmployeeDTO> list = new ArrayList<>();  
		   try {
				conn = DBUtility.getConnectionToDataBase();
				
				String query = "select e.empId,e.ename,e.email,e.empAddress,e.Salary_Per_Month,e.date_of_joining,d.deptID,"
						+ "d.deptName from Employee e INNER JOIN Dept d  ON e.did = d.did where is_delete = 0";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();
				if(DBUtility.isResultSetEmpty(rs)) {
					throw new NoSuchRecordFoundException("There is no such record avaiable");
				}
			  while(rs.next()) {
				  list.add(new EmployeeDTOImpl(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),"xxxxxxx",rs.getDouble(5),
						  		rs.getDate(6).toLocalDate(), new DepartmentDTOImpl(rs.getString(7),rs.getString(8))));
			  }
				
			} catch (ClassNotFoundException |SQLException e) {
				//throw new SomthingWentWrongException("Unable to connection with database! please try again");
				throw new SomthingWentWrongException(e.getMessage());
			}finally{
				try {
					DBUtility.closeConnectionToDataBase(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		  
		   return list;
	}
	
	
	
}
