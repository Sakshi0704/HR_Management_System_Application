package com.masai.dto;

import java.time.LocalDate;

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
			 LocalDate date,DepartmentDTO dept) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.email = email;
		this.password = password;
		this.empAddress= empAddress;
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
		return " empId = " + empId + ", ename = " + ename + ", email = " + email + ", password = " + password
				+ " empAddress = " + empAddress + ",\n salary = " + salary + ", deptId = " + dept.getDeptID()+", deptName = " +dept.getDiptname()+ ", date_of_joining = " + date + "\n";
	}

	@Override
	public String toString1() {
		// TODO Auto-generated method stub
		return " empId = " + empId + "\n ename = " + ename + "\n email = " + email + "\n password = " + password
				+ "\n empAddress = " + empAddress + "\n salary = " + salary + "\n deptId = " + dept.getDeptID()+"\n deptName = " +dept.getDiptname()+ ",\n date_of_joining = " + date;
	}

	
}
