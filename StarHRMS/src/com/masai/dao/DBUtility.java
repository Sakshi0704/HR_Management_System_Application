package com.masai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtility {

	public static Connection getConnectionToDataBase() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		ResourceBundle rb = ResourceBundle.getBundle("dbdetailes");

		return DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
	}

	public static void closeConnectionToDataBase(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			return true;
		}
		return false;
	}
}
