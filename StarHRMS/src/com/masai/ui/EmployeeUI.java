package com.masai.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

public abstract class EmployeeUI {
	
	private static int empId;
	private static String empName;
	private static boolean logIn = false;
	
	private static void employeeMenu() {
		System.out.println("-------------------Welcome "+ empName + "--------------------------");
		System.out.println("\n");
		System.out.println("-------Employee DashBord--------");
		System.out.println("------------------------------");
		System.out.println("\n\r Please Choose an Option ------------\n\r");
		System.out.println("Press 1 : < ---- > View Your Profile \n\r");
		System.out.println("Press 2 : < ---- > Update Profile Or To Change Your Password\n\r");
		System.out.println("Press 3 : < ---- > Apply for Leave \r\n");
		System.out.println("Press 4 : < ---- > Record of Leave \r\n");
		System.out.println("Press 5 : < ---- > Total_Salary Of A Financial year  \r\n");
		System.out.println("Press 0 : < ---- > LogOut i.e. Go Back To Home \n\r");
	}
	
   static void empLogInUI(Scanner sr) {
		System.out.println("Enter Your Username( EmailID ):   ");
		String emailId = sr.next();
		System.out.println("Enter Your Password : ");
		String password = sr.next();
		
		List<String> list = new ArrayList<>();
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			list = empDAO.empLogIn(emailId,password);
			empId = Integer.parseInt(list.get(0));
			empName = list.get(1);
			logIn = true;
			System.out.println("------------- LogIn Successfully ----------------");
			employee(sr);
		} catch (WrongCredentialsException | SomthingWentWrongException e) {
			System.out.println(e);
		}
	}
   	
    abstract void viewYourProfileUI();
   abstract void updateProfileUI(Scanner sr);
   abstract  void changePasswordUI(Scanner sr);
   abstract  void applyforLeaveUI(Scanner sr);
   abstract void recordOfLeaveUI(Scanner sr);
   abstract void totalSalaryAnnualyUI(Scanner sr);
   
	
		public static int getEmpId() {
			return empId;
		}
		
		public static String getEmpName() {
			return empName;
		}
	
		public static boolean isLogIn() {
			return logIn;
		}
		

	static void employee(Scanner sr) {
		int choice = 0;
		while(logIn){
			EmployeeUI employee = new EmployeeUIImpl();
			employeeMenu();
			System.out.print("Enter Your Choice : ");
			choice = sr.nextInt();
			
			switch(choice) {
				case 1:
					employee.viewYourProfileUI();
					break;
				case 2:
					employee.updateProfileUI(sr);
					break;
				case 3:
					employee.applyforLeaveUI(sr);
					break;
					
				case 4: 
					employee.recordOfLeaveUI(sr);
					
				case 5: 
					employee.totalSalaryAnnualyUI(sr);
				case 0:
					System.out.println("------------Thanks For Your Visit!-------------");
					logIn = false;
					break;
					
				default: 
					System.out.println("-----Opps! Wrong choice ... please try again \r\n");
			}
		}
	}
}
