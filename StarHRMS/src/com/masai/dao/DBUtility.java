package com.masai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Utility class for working with the database.
 * 
 * @author Km Sakshi
 */
public class DBUtility {

	/**
	 * Establishes a connection to the database.
	 *
	 * @return the database connection
	 * 
	 * @throws ClassNotFoundException if the database driver class is not found
	 * 
	 * @throws SQLException           if a database access error occurs
	 */
	public static Connection getConnectionToDataBase() throws ClassNotFoundException, SQLException {

		// Load the database driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Get the database connection details from a resource bundle
		ResourceBundle rb = ResourceBundle.getBundle("dbdetailes");

		// Establish the database connection
		return DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
	}

	/**
	 * Closes the database connection.
	 *
	 * @param conn the database connection to close
	 * 
	 * @throws SQLException if a database access error occurs
	 */
	public static void closeConnectionToDataBase(Connection conn) throws SQLException {
		// Close the database connection if it's not null
		if (conn != null) {
			conn.close();
		}
	}

	/**
	 * Checks if a ResultSet is empty.
	 *
	 * @param rs the ResultSet to check
	 * 
	 * @return true if the ResultSet is empty, false otherwise
	 * 
	 * @throws SQLException if a database access error occurs
	 */
	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		// Check if the ResultSet is empty
		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			return true;
		}
		return false;
	}
}
