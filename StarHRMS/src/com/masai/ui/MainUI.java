package com.masai.ui;

import java.util.Scanner;


public class MainUI {
	
	static void adminLink(Scanner sr) throws InterruptedException {
		int choice = 0;
		do {
			System.out.println("====================================================");
			System.out.println("Press 1: LogIn To Admin panel         		");
			System.out.println("Press 0: Wants to go back to Home Page		");
			System.out.println("====================================================");
			System.out.println("Enter your choice : ");
			choice = sr.nextInt();
			switch(choice) {
				case 1: 
					AdminUI.adminLogInUI(sr);
					 break;
				case 0:
					System.out.println(".......Byee-Byee.......");
					break;
				default: 
					System.out.println("--Opps! Wrong choice! please try again.....");
			}
		}while(choice!=0);
	}
	
	static void employeeLink(Scanner sr) {
		int choice = 0;
		do {
			System.out.println("====================================================");
			System.out.println("Press 1: LogIn To Employee Page         		");
			System.out.println("Press 0: Wants to go back to Home Page		");
			System.out.println("====================================================");
			System.out.println("Enter your choice : ");
			choice = sr.nextInt();
			switch(choice) {
				case 1: 
					EmployeeUI.empLogInUI(sr);
					 break;
				case 0:
					System.out.println(".......Byee-Byee.......");
					break;
				default: 
					System.out.println("--Opps! Wrong choice! please try again.....");
			}
		}while(choice!=0);
		
	}
	
	
	public static void main(String args[]) throws InterruptedException {
		Scanner sr = new Scanner(System.in);
		System.out.println("-----------WELCOME-------------");
		System.out.println("---StarHR Management System----");
		System.out.println("-------------------------------");
		
		
		System.out.println("-------------------------------");
		int choice = 0;
		do {
			System.out.println("----WHERE YOU WANT TO VISIT----");
			System.out.println("Press 1: ---> Admin Page ");
			System.out.println("Press 2: ----> Employee Page ");
			System.out.println("Press 3: ----> Exit ");
			System.out.print("Enter your selection : ");
			choice = sr.nextInt();
			switch(choice) {
			case 1: 
				adminLink(sr);
				break;
			case 2:
				 employeeLink(sr);
				 break;
			case 0:
				System.out.println("-----------Thanks For Visit!----------");
				break;
			default:
				System.out.println("Opps! try again wrong selection");
				Thread.sleep(1000);
				break; 
			}
			
		}while(choice!=0);
		
		sr.close();
		
	}
}
