package com.masai.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.masai.dto.DepartmentDTO;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.LeaveDTO;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;

public interface AdminDAO {

	void addNewDepartment(String deptId,String deptName) throws SomthingWentWrongException;

	List<DepartmentDTO> viewAllDepartment()throws SomthingWentWrongException,NoSuchRecordFoundException;

	void updateDepartmentAllDetails(String oldDeptID, String deptId, String deptName)
			throws SomthingWentWrongException, NoSuchRecordFoundException;
	public List<EmployeeDTO> viewAllEmployee() throws NoSuchRecordFoundException, SomthingWentWrongException;

	void addNewEmployee(EmployeeDTO employee, int deptID) throws SomthingWentWrongException;

	void deleteDepartment(String deptID) throws SomthingWentWrongException;

	void transferemployeetootherdepart(int eId, int did)throws SomthingWentWrongException;

	void fireEmployee(int eId)throws SomthingWentWrongException;

	Map<Integer, LeaveDTO> getListOfLeaveRequst()throws SomthingWentWrongException;

	void acceptLeaveOfEmployee(int leaveId)throws SomthingWentWrongException;

	void rejectLeaveOfEmployee(int leaveId)throws SomthingWentWrongException;

}