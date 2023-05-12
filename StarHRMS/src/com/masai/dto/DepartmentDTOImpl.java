package com.masai.dto;

/**
 * The DepartmentDTOImpl class is an implementation of the DepartmentDTO interface.
 * It represents a department data transfer object with its ID and name.
 * @author Km Sakshi
 */
public class DepartmentDTOImpl implements DepartmentDTO {

	private String deptID;
	private String diptname;

	public DepartmentDTOImpl() {
	};

	public DepartmentDTOImpl(String deptID, String diptname) {
		super();
		this.deptID = deptID;
		this.diptname = diptname;
	}

	@Override
	public String getDeptID() {
		return deptID;
	}

	@Override
	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	@Override
	public String getDiptname() {
		return diptname;
	}

	@Override
	public void setDiptname(String diptname) {
		this.diptname = diptname;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(String.format("|         %-6s          |         %-20s|\n", deptID, diptname));
	    sb.append("+-------------------------+-----------------------------+");
	    return sb.toString();
	}

}
