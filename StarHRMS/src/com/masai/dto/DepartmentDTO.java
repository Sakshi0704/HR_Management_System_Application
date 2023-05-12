package com.masai.dto;

/**
 * The DepartmentDTO interface represents the data transfer object for a department.
 * It provides methods to get and set the department ID and department name.
 * @author Km Sakshi
 */
public interface DepartmentDTO {

    /**
     * Get the department ID.
     * @return The department ID.
     */
    public String getDeptID();
    
    
    /**
     * Set the department ID.
     * @param deptID The department ID to set.
     */
    public void setDeptID(String deptID);
    
    
    /**
     * Get the department name.
     * @return The department name.
     */
    public String getDiptname();
    
    
    /**
     * Set the department name.
     * @param diptname The department name to set.
     */
    public void setDiptname(String diptname);
    
}



