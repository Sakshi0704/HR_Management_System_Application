package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.DepartmentDTO;
import com.masai.dto.DepartmentDTOImpl;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;

public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public void addNewDepartment(String deptId, String deptName) throws SomthingWentWrongException {
		 
		Connection conn = null;
		
		try {
			conn = DBUtility.getConnectionToDataBase();
			String query = "insert into dept (deptID,deptName) value ('D003','HR')";
			Statement st = conn.createStatement();
			st.executeUpdate(query);
		}catch(SQLException | ClassNotFoundException ex) {
			throw new SomthingWentWrongException(ex.getMessage());
			
		}finally {
			try {
				DBUtility.closeConnectionToDataBase(conn);
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
	}

	@Override
	public List<DepartmentDTO> viewAllDepartment() throws SomthingWentWrongException,NoSuchRecordFoundException{
		
		Connection conn = null;
		List<DepartmentDTO> list = null;
		
		try {
			conn = DBUtility.getConnectionToDataBase();
			String query = "select deptID , deptName from dept  where is_delete = 0";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(DBUtility.isResultSetEmpty(rs)) {
				throw new NoSuchRecordFoundException("There is no record to review");
			}
			
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new DepartmentDTOImpl(rs.getString(1),rs.getString(2)));
			}
		
		}catch(ClassNotFoundException | SQLException ex ) {
			throw new SomthingWentWrongException("Unable to get data please try again leter");
		}finally {
			try {
				DBUtility.closeConnectionToDataBase(conn);
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return list;
	}

	@Override
	public void updateDepartmentAllDetails(String oldDeptID,String deptId, String deptName)
			throws SomthingWentWrongException, NoSuchRecordFoundException {
			
		Connection conn = null;
		
		try {
			conn = DBUtility.getConnectionToDataBase();
			String query = "Update dept set deptID = ? , deptName = ? where deptID = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, deptId);
			ps.setString(2,deptName);
			ps.setString(3, oldDeptID);
			
			ResultSet rs = ps.executeQuery();
			
			if(DBUtility.isResultSetEmpty(rs)) {
				throw new NoSuchRecordFoundException("No Such Record Found");
			}
			
		}catch(SQLException | ClassNotFoundException ex) {
			throw new SomthingWentWrongException(ex.getMessage());
			
		}finally {
			try {
				DBUtility.closeConnectionToDataBase(conn);
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
	}

}