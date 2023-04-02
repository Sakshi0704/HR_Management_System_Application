package com.masai.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.LeaveDTO;
import com.masai.dto.LeaveDTOImpl;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;

public class EmployeeUIImpl extends EmployeeUI{

	static void updateMenu() {
		System.out.println("Select your choice want you want to update ............");
		System.out.println("Press 1: Address");
		System.out.println("Press 2: emailId");
		System.out.println("Press 3: Password");
	}
	@Override
	public void viewYourProfileUI() {
		//String empName = EmployeeUI.getEmpName();
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
			try {
				EmployeeDTO employee = empDAO.viewYourProfile(EmployeeUI.getEmpId());
				System.out.println(employee.toString1());
				
			} catch (NoSuchRecordFoundException | SomthingWentWrongException e) {
				System.out.println(e);
			}
	}

	@Override
	public void updateProfileUI(Scanner sr) {
		System.out.println("............................................");
		EmployeeUIImpl.updateMenu();
		String choice = "0";
		do {
			
			System.out.print("Enter your selection: ");
			choice = sr.next();
			switch(choice) {
				case "1":
					System.out.println("  Sorry this service is termery close please connect with admin department\n ");
					break;
				case "2":
					System.out.println("  Sorry this service is termery close please connect with admin department\n ");
					break;
				case "3":
					changePasswordUI(sr);
					System.out.println();
					break;
					
				default: 
					System.out.println("  Opps !! Wrong Choice !! Please Enter Correct Choice..");
			}
			
		}while(!choice.equals("1")&&!choice.equals("2")&&!choice.equals("3"));
		
	}

	@Override
	public void changePasswordUI(Scanner sr) {
		System.out.println("============================================");
		System.out.println("Change Your Password");
		System.out.print("Please Enter Your old Password : ");
		String oldPassword = sr.next();
		System.out.println("Please Enter Updated Password : ");
		String updatedPassword = sr.next();
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			empDAO.changePassword(oldPassword,updatedPassword,EmployeeUI.getEmpId());
			System.out.println("Update Successfull");
			
		}catch(NoSuchRecordFoundException | SomthingWentWrongException ex){
			System.out.println(ex);
		}
		System.out.println("============================================");
		
	}
	
	private static void leaveMenu() {
		System.out.println("Press 1 : for Complementary Leave");
		System.out.println("Press 2 : for Sick Leave");
		System.out.println("Press 3 : for Extra Leave");
	}

	@Override
	public void applyforLeaveUI(Scanner sr) {
		System.out.println(".............................................");
		System.out.println("Apply for Leave ....");
		int type = 0;
		EmployeeUIImpl.leaveMenu();
		String choice = "0";
		do {
				System.out.println("Enter type of leave : ");
				choice = sr.next();
				switch(choice) {
				case "1":
					type = 1;
					break;
				case "2":
					type = 2;
					break;
				case "3":
					type = 3;
					break;
					
				default: 
					System.out.println(" Wrong input please enter correct choice....");
			}
			
		}while(!choice.equals("1")&&!choice.equals("2")&&!choice.equals("3"));
			
		System.out.println("Enter How Many Days you want to take leave : ");
		int days_Of_Leave = sr.nextInt();
		
		sr.nextLine();
		
		System.out.println("Reason for leave : ");
		String reason = sr.nextLine();

		LeaveDTO leave = new LeaveDTOImpl(days_Of_Leave,type,reason);
				
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			empDAO.applyForLeave(leave,EmployeeUI.getEmpId());
			System.out.println("Apply for Leave Successfully");
			
		}catch(SomthingWentWrongException ex){
			System.out.println(ex);
		}
		System.out.println("============================================");
		
	}
	
	@Override
	void leaveStatus(Scanner sr) {
		System.out.println("=============================================");
		System.out.println("Recent Leave Request Status ....");
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			LeaveDTO empLeave = empDAO.leaveStatus(EmployeeUI.getEmpId());
			System.out.println(empLeave.toString1()); // need to work on 
				Thread.sleep(1000);
			
		}catch(NoSuchRecordFoundException|SomthingWentWrongException | InterruptedException ex) {
			System.out.println(ex);
		}
		
		System.out.println("=============================================");
		
	}

	@Override
	public void recordOfLeaveUI(Scanner sr) {
		System.out.println("=============================================");
		System.out.println("Recent Accept Leaves Record ......");
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			List<LeaveDTO>  list = empDAO.recordOfLeave(EmployeeUI.getEmpId());
			list.stream().forEach(System.out::println);   // need to work on it
			
		}catch(NoSuchRecordFoundException|SomthingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("=============================================");
	}

	@Override
	void totalSalaryMonthUI(Scanner sr) {
		System.out.println("=============================================");
		System.out.println("To Get Selective Month Salary......");
		System.out.println("Enter Starting date of The month (yyyy-mm-dd): ");
		LocalDate startDate = LocalDate.parse(sr.next());
		System.out.println("Enter End date of The month (yyyy-mm-dd):  ");
		LocalDate endDate = LocalDate.parse(sr.next());
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			double salary = empDAO.totalSalaryOfMonth(startDate,endDate,EmployeeUI.getEmpId());
			System.out.println(salary);  // need to work on it
			
		}catch(SomthingWentWrongException ex) {
			System.out.println(ex);
		}
		
		System.out.println("=============================================");
		
	}
	
	@Override
	public void totalSalaryAnnualyUI(Scanner sr) {
		System.out.println("=============================================");
		
		System.out.println(" Annual Salary Record of Employee......");
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			double salary = empDAO.totalSalaryAnnualy(EmployeeUI.getEmpId());
			System.out.println(salary);  // need to work on it
			
		}catch(SomthingWentWrongException ex) {
			System.out.println(ex);
		}
		
		System.out.println("=============================================");
		
	}
	

}
