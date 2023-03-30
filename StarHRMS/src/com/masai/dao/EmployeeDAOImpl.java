package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			ResultSet rs = ps.executeQuery();
			if(DBUtility.isResultSetEmpty(rs)) {
				throw new WrongCredentialsException("Wrong Login Credentials");
			}
		  while(rs.next()) {
			  list.add(rs.getString(1));
			  list.add(rs.getString(2));
		  }
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomthingWentWrongException("Unabl to connection with database! please try again");
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
