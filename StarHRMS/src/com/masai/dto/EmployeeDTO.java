package com.masai.dto;

import java.time.LocalDate;

public interface EmployeeDTO {
	public String getEmpId();

	public void setEmpId(String empId);

	public String getEname();

	public void setEname(String ename);

	public String getEmail();

	public void setEmail(String email);
	public String getPassword();
	public void setPassword(String password);
	public double getSalary();
	public void setSalary(double salary);

	public DepartmentDTO getDept();

	public void setDept(DepartmentDTO dept);

	public LocalDate getDate();
	
	public void setDate(LocalDate date);
	
	public String getEmpAddress();

	public void setEmpAddress(String empAddress);
	
}
