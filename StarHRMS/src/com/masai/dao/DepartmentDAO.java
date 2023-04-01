package com.masai.dao;

import java.sql.SQLException;
import java.util.List;

import com.masai.dto.DepartmentDTO;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;

public interface DepartmentDAO {

	void addNewDepartment(String deptId, String deptName) throws SomthingWentWrongException;

	List<DepartmentDTO> viewAllDepartment()throws SomthingWentWrongException,NoSuchRecordFoundException;

	void updateDepartmentAllDetails(String oldDeptID, String deptId, String deptName)
			throws SomthingWentWrongException, NoSuchRecordFoundException;

}
