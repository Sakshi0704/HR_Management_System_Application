package com.masai.dto;

import java.time.LocalDate;

import com.masai.color.ConsoleColor;

/**
 * The EmployeeDTOImpl class is an implementation of the EmployeeDTO interface.
 * It represents a data transfer object for an employee and provides methods
 * to get and set various attributes of the employee.
 * @author Km Sakshi
 */
public class EmployeeDTOImpl implements EmployeeDTO {

	private String empId;
	private String ename;
	private String email;
	private String password = "123456";
	private String empAddress;
	private double salary;
	private DepartmentDTO dept;
	LocalDate date = LocalDate.now();

	public EmployeeDTOImpl() {

	}

	public EmployeeDTOImpl(String empId, String ename, String email, String empAddress, String password, double salary,
			LocalDate date, DepartmentDTO dept) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.email = email;
		this.password = password;
		this.empAddress = empAddress;
		this.salary = salary;
		this.dept = dept;
		this.date = date;
	}

	@Override
	public String getEmpId() {
		return empId;
	}

	@Override
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String getEname() {
		return ename;
	}

	@Override
	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getEmpAddress() {
		return empAddress;
	}

	@Override
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public DepartmentDTO getDept() {
		return dept;
	}

	@Override
	public void setDept(DepartmentDTO dept) {
		this.dept = dept;
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	   
	    sb.append(String.format("|  %-5s  |      %-10s  |  %-14s  |      %-10s  |      %-10s  | %-6.2f  |  %-6s  |  %-14s |  %-13s |\n", empId, ename, email, password, empAddress, salary, dept.getDeptID(),dept.getDiptname(),date));
	    sb.append("+---------+------------------+------------------+------------------+------------------+-----------+----------+-----------------+----------------+");
	    return sb.toString();
	}
	
	@Override
	public String toString1() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(ConsoleColor.BANANA_YELLOW + "+--------------------------------------------+\n");
	    sb.append("|          Employee Details                  |\n");
	    sb.append("+--------------------------------------------+\n");
	    sb.append("| empId          : " + empId + "                      |\n");
	    sb.append("| ename          : " + ename + "                    |\n");
	    sb.append("| email          : " + email + "             |\n");
	    sb.append("| password       : " + password + "                   |\n");
	    sb.append("| empAddress     : " + empAddress + "                     |\n");
	    sb.append("| salary         : " + salary + "                   |\n");
	    sb.append("| deptId         : " + dept.getDeptID() + "                      |\n");
	    sb.append("| deptName       : " + dept.getDiptname() + "                      |\n");
	    sb.append("| date_of_joining: " + date + "                |\n");
	    sb.append("+--------------------------------------------+" + ConsoleColor.RESET);
	    return sb.toString();
	}

}
