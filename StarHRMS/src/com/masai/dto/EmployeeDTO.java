package com.masai.dto;

import java.time.LocalDate;

/**
 * The EmployeeDTO interface represents a data transfer object for an employee.
 * It defines methods to get and set various attributes of an employee.
 * @author Km Sakshi
 */
public interface EmployeeDTO {

    /**
     * Gets the employee ID.
     * @return the employee ID
     */
    public String getEmpId();

    /**
     * Sets the employee ID.
     * @param empId the employee ID to set
     */
    public void setEmpId(String empId);

    /**
     * Gets the employee name.
     * @return the employee name
     */
    public String getEname();

    /**
     * Sets the employee name.
     * @param ename the employee name to set
     */
    public void setEname(String ename);

    /**
     * Gets the employee email.
     * @return the employee email
     */
    public String getEmail();

    /**
     * Sets the employee email.
     * @param email the employee email to set
     */
    public void setEmail(String email);

    /**
     * Gets the employee password.
     * @return the employee password
     */
    public String getPassword();

    /**
     * Sets the employee password.
     * @param password the employee password to set
     */
    public void setPassword(String password);

    /**
     * Gets the employee salary.
     * @return the employee salary
     */
    public double getSalary();

    /**
     * Sets the employee salary.
     * @param salary the employee salary to set
     */
    public void setSalary(double salary);

    /**
     * Gets the department of the employee.
     * @return the department of the employee
     */
    public DepartmentDTO getDept();

    /**
     * Sets the department of the employee.
     * @param dept the department of the employee to set
     */
    public void setDept(DepartmentDTO dept);

    /**
     * Gets the employee's joining date.
     * @return the employee's joining date
     */
    public LocalDate getDate();

    /**
     * Sets the employee's joining date.
     * @param date the employee's joining date to set
     */
    public void setDate(LocalDate date);

    /**
     * Gets the employee's address.
     * @return the employee's address
     */
    public String getEmpAddress();

    /**
     * Sets the employee's address.
     * @param empAddress the employee's address to set
     */
    public void setEmpAddress(String empAddress);

    /**
     * Returns a string representation of the employee.
     * @return a string representation of the employee
     */
    public String toString1();

}
