package com.masai.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

public class EmployeeUI {
	
	private static int empId;
	private static String empName;
	private static boolean logIn = false;
	
	static void employeeMenu() {
		System.out.println("\n");
		System.out.println("-------Employee DashBord--------");
		System.out.println("------------------------------");
		System.out.println("\n\r Please Choose an Option ------------\n\r");
		System.out.println("Press 1 : < ---- > View Your Profile \n\r");
		System.out.println("Press 2 : < ---- > Update Profile \n\r");
		System.out.println("Press 3 : < ---- > Change Password \r\n");
		System.out.println("Press 4 : < ---- > Apply for Leave \r\n");
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
			employee(sr);
		} catch (WrongCredentialsException | SomthingWentWrongException e) {
			e.printStackTrace();
		}
	}
   	

	
	static void employee(Scanner sr) {
		int choice = 0;
		while(logIn){
			employeeMenu();
			System.out.print("Enter Your Choice : ");
			choice = sr.nextInt();
			
			switch(choice) {
				case 1:
					//viewYourProfile();
					break;
				case 2:
					//updateProfile();
					break;
				case 3:
					//changePassword();
					break;
				case 4:
					//applyforLeave();
					break;
					
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
