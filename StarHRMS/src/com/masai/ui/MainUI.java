package com.masai.ui;

import java.util.Scanner;

import com.masai.color.ConsoleColor;


public class MainUI {
	
	static void adminLink(Scanner sr) throws InterruptedException {
		String choice = "0";
		do {
			System.out.println(ConsoleColor.BANANA_YELLOW + "====================================================" +ConsoleColor.RESET);
			System.out.println("Press 1: < ---- > LogIn To Admin panel         		");
			System.out.println("Press 0: < ---- > Wants to go back to Home Page		");
			System.out.println("====================================================");
			System.out.println("Enter your choice : ");
			choice = sr.next();
			switch(choice) {
				case "1": 
					AdminUI.adminLogInUI(sr);
					 break;
				case "0":
					System.out.println(".......Byee-Byee.......");
					break;
				default: 
					System.out.println("--Opps! Wrong choice! please try again.....");
			}
		}while(!choice.equals("0"));
	}
	
	static void employeeLink(Scanner sr) {
		String choice = "0";
		do {
			System.out.println("====================================================");
			System.out.println("Press 1: < ---- >  LogIn To Employee Page         		");
			System.out.println("Press 0: < ---- >  Wants to go back to Home Page		");
			System.out.println("====================================================");
			System.out.println("Enter your choice : ");
			choice = sr.next();
			switch(choice) {
				case "1": 
					EmployeeUI.empLogInUI(sr);
					 break;
				case "0":
					System.out.println(".......Byee-Byee.......");
					break;
				default: 
					System.out.println("--Opps! Wrong choice! please try again.....");
			}
		}while(!choice.equals("0"));
		
	}
	
	
	public static void main(String args[]) throws InterruptedException {
		Scanner sr = new Scanner(System.in);
		System.out.println(ConsoleColor.YELLOW+ "-----------WELCOME-------------");
		System.out.println("---StarHR Management System----");
		System.out.println("-------------------------------"+ConsoleColor.RESET);
		
		
		System.out.println("-------------------------------");
		String choice = "0";
		do {
			System.out.println("----WHERE YOU WANT TO VISIT----");
			System.out.println("Press 1: < ---- > Admin Page ");
			System.out.println("Press 2: < ---- > Employee Page ");
			System.out.println("Press 0: < ---- > Exit ");
			System.out.print("Enter your selection : ");
			choice = sr.next();
			switch(choice) {
			case "1": 
				adminLink(sr);
				break;
			case "2":
				 employeeLink(sr);
				 break;
			case "0":
				System.out.println("-----------Thanks For Visit!----------");
				break;
			default:
				System.out.println("Opps! try again wrong selection");
				Thread.sleep(1000);
				break; 
			}
			
		}while(!choice.equals("0"));
		
		sr.close();
		
	}
}
