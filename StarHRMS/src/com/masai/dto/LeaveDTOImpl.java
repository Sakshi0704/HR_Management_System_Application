package com.masai.dto;

import java.time.LocalDate;
import com.masai.color.ConsoleColor;

/**
 * The LeaveDTOImpl class implements the LeaveDTO interface represents a data
 * transfer object for employee leaves. It provides getters and setters for
 * various attributes of a leave and overrides the toString1() method.
 * 
 * @author Km Sakshi
 */
public class LeaveDTOImpl implements LeaveDTO {
	int leaveId;
	int days_of_leave;
	int type;
	String reason;
	LocalDate date;
	String status;
	String empId;
	String empName;

	// leaveId,days_of_leave,type,reason,date_of_leave,status,e.eId,e.ename

	public LeaveDTOImpl(int days_of_leave, int type, String reason) {
		super();
		this.days_of_leave = days_of_leave;
		this.type = type;
		this.reason = reason;
	}

	public LeaveDTOImpl(int days_of_leave, int type, String reason, LocalDate date, String status, String empId,
			String empName) {
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
		if (getType() == 1) {
			return "Complementary Leave";
		} else if (getType() == 2) {
			return "Sick Leave";
		} else {
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

//	@Override
//	public String toString() {
//	    StringBuilder sb = new StringBuilder();
//	    sb.append(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD+"+--------------------------------------------------+");
//	    sb.append("|                   Leave Information             |");
//	    sb.append("|--------------------------------------------------|"+ConsoleColor.RESET);
//	    sb.append("|  empId  |  empName  |  days_of_leave  |     type     |   reason   |\n");
//	    sb.append("+----------------------------------------------------------------+\n");
//	    sb.append(String.format("|  %-6d |  %-8s |  %-14d |  %-12s |  %-10s |\n", empId, empName, days_of_leave, getTypeInWords(), reason));
//	    sb.append("+----------------------------------------------------------------+\n");
//	    sb.append("|                      date             |     status              |\n");
//	    sb.append("+----------------------------------------------------------------+\n");
//	    sb.append(String.format("|  %-35s |  %-20s |\n", date, status));
//	    sb.append("+----------------------------------------------------------------+\n");
//	    return sb.toString();
//	}

	@Override
	public String toString1() {
		StringBuilder sb = new StringBuilder();
		sb.append(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
				+ "+--------------------------------------------------+\n");
		sb.append("|             Leave Information                   |\n");
		sb.append("|--------------------------------------------------|" + ConsoleColor.RESET + "\n");
		sb.append("| empId = ").append(empId).append(",\n");
		sb.append("| empName = ").append(empName).append(",\n");
		sb.append("| days_of_leave = ").append(days_of_leave).append(",\n");
		sb.append("| type = ").append(getTypeInWords()).append(",\n");
		sb.append("| reason = ").append(reason).append(",\n");
		sb.append("| date = ").append(date).append(",\n");
		sb.append(ConsoleColor.YELLOW + "| status = ").append(status);
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("|  %-7s  |  %-15s |  %-15d |  %-7s |  %-15s |  %-12s |  %-9s |\n", empId, empName,
				days_of_leave, type, reason, date, status));
		sb.append(
				"+------------+-----------+------------------+------------------+----------+------------------+---------------+------------+");
		return sb.toString();
	}
}
