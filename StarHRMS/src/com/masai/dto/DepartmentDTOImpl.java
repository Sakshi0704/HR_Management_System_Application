package com.masai.dto;

public class DepartmentDTOImpl implements DepartmentDTO {

	private String deptID;
	private String diptname;
	
	public DepartmentDTOImpl() {};
	
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
		return " deptID=" + deptID + ", diptname=" + diptname ;
	}
	
	
	
	
}
