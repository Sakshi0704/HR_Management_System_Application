package com.masai.dto;

import java.sql.Date;
import java.time.LocalDate;

public class LeaveDTOImpl implements LeaveDTO {
	int leaveId;
	int days_of_leave;
	int type;
	String reason;
	LocalDate date;
	String status;
	String empId;
	String empName;
	
	//leaveId,days_of_leave,type,reason,date_of_leave,status,e.eId,e.ename 
	
	public LeaveDTOImpl(int days_of_leave, int type, String reason) {
		super();
		this.days_of_leave = days_of_leave;
		this.type = type;
		this.reason = reason;
	 }
	
	public LeaveDTOImpl(int days_of_leave, int type, String reason,LocalDate date, String status,String empId,String empName) {
		super();
		this.days_of_leave = days_of_leave;
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.status = status;
		this.empId = empId;
		this.empName = empName;
	 }

	@Override
	public int getDays_of_leave() {
		return days_of_leave;
	}

	@Override
	public void setDays_of_leave(int days_of_leave) {
		this.days_of_leave = days_of_leave;
	}

	@Override
	public int getType() {
		return type;
	}
	
	

	@Override
	public String getTypeInWords() {
		if(getType()==1) {
			return "Complementary Leave";
		}
		else if(getType()==2) {
			return "Sick Leave";
		}
		else {
			return "Extra Leave";
		}
	}

	@Override
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String getReason() {
		return reason;
	}

	@Override
	public void setReason(String reason) {
		this.reason = reason;
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
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int getLeaveId() {
		return leaveId;
	}

	@Override
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
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
	public String getEmpName() {
		return empName;
	}

	@Override
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "LeaveDTOImpl [leaveId=" + leaveId + ", empId=" + empId + ", empName=" + empName + ", days_of_leave=" + days_of_leave + ", type=" + type + ", reason="
				+ reason + ", date=" + date + ", status=" + status  + "]";
	}
	
}
