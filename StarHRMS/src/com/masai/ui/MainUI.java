package com.masai.ui;

import java.util.Scanner;


public class MainUI {
	
	static void adminLink(Scanner sr) throws InterruptedException {
		System.out.println("--------- LogIn To Admin -----------");
		System.out.println("=====================================");
		int i=0,choice =1;
		do {
			System.out.println("Enter Your Username :  ");
			String username = sr.next();
			System.out.println("Enter Your Password :  ");
			String password = sr.next();
			if(username.equals("Admin") && password.equals("Admin")) {
				 System.out.println("----------- Login Successfully !!! ------------");
				 Thread.sleep(1000);
				 System.out.println("\n");
					System.out.println("-------Admine DashBord--------");
					System.out.println("------------------------------");
				 AdminUI.admin(sr);
				 break;
			}
			else {
				System.out.println("-----------------Wrong Credentials");
				System.out.println("=================================\r\n");
				if(i!=3) {
					System.out.println("Press 1: Wants to try again!!!");
					System.out.println("Press 0: Want to go back to Home paga\n");
					System.out.print("Enter your choice:  ");
					choice = sr.nextInt();
					i++;
				}
				else {
					System.out.println("-----------------Already Try Three Times");
					System.out.println("----------------Visit after some Time!!!");
				}
			}
		}while(i!=3||choice!=0);
	}
	
	
	static void employeeLink(Scanner sr) {
		int choice = 0;
		do {
			System.out.println("====================================================");
			System.out.println("              		Press 1: LogIn          		");
			System.out.println("		Press 0: Wants to go back to Home Page		");
			System.out.println("====================================================");
			System.out.println("				Enter your choice : ");
			choice = sr.nextInt();
			switch(choice) {
				case 1: 
					EmployeeUI.empLogInUI(sr);
					 break;
				case 0:
					System.out.println("			.......Byee-Byee.......			");
					break;
				default: 
					System.out.println("	Opps! Wrong choice! please try again.....");
			}
		}while(choice!=0);
		
	}
	
	
	public static void main(String args[]) throws InterruptedException {
		Scanner sr = new Scanner(System.in);
		System.out.println("			------------WELCOME------------				");
		System.out.println("			---StarHR Management System----				");
		System.out.println("--------------------------------------------------------");
		
		
		System.out.println("			---------------------------------------		");
		int choice = 0;
		do {
			System.out.println("		----WHERE YOU WANT TO VISIT----				");
			System.out.println("	Press 1: ---> Admin Page \n\r 		Press 2: ----> Employee Page \r\n 		Press 3: ----> Exit");	
			System.out.println("Enter your selection : ");
			choice = sr.nextInt();
			switch(choice) {
			case 1: 
				adminLink(sr);
				break;
			case 2:
				 employeeLink(sr);
				 break;
			case 0:
				System.out.println("	-----------Thanks For Visit!----------		");
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
