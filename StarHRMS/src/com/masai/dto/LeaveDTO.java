package com.masai.dto;

import java.time.LocalDate;

public interface LeaveDTO {

	public int getDays_of_leave();

	public void setDays_of_leave(int days_of_leave);

	public int getType();
	
	public String getTypeInWords();

	public void setType(int type);

	public String getReason();
	
	public void setReason(String reason);
	
	public LocalDate getDate();

	public void setDate(LocalDate date);
	

	public String getStatus();

	public void setStatus(String status);
	
	public int getLeaveId();

	public void setLeaveId(int leaveId);

	public String getEmpId();

	public void setEmpId(String empId);

	public String getEmpName();

	public void setEmpName(String empName);
	
}
