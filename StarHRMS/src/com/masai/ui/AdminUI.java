package com.masai.ui;

import java.util.Scanner;

public class AdminUI {

	static void adminMenu() {
		System.out.println("\n\r Please Choose an Option ------------\n\r");
		System.out.println("Press 1 : < ---- > Add New Department \n\r");
		System.out.println("Press 2 : < ---- > View All The Departments \n\r");
		System.out.println("Press 3 : < ---- > View All The Employees \r\n");
		System.out.println("Press 4 : < ---- > Update The Department \r\n");
		System.out.println("Press 5 : < ---- > Add New Employee \n\r");
		System.out.println("Press 6 : < ---- > Transfer employee to other department \r\n");
		System.out.println("Press 7 : < ---- > Accept Leaves Of Employee \n\r");
		System.out.println("Press 8 : < ---- > Reject Leaves Of Employee \n\r");
		System.out.println("Press 9 : < ---- > Delete Department \n\r");
		System.out.println("Press 10 : < ---- > Go Back To Home \n\r");
		System.out.println("Press 0 : < ---- > Exit \n\r");
	}
	
	public static void admin(Scanner sr) {
		int choice = 0;
		do {
			adminMenu();
		    System.out.print("Enter your selection : ");
		    choice = sr.nextInt();
		    System.out.println();
		    switch(choice) {
		    		case 1:
		    			//addNewDepartment(sr);
		    			break;
		    		
		    		case 2:
		    			 //viewAllDepartment(sr);
		    			 break;
		    		
		    		case 3:
		    			 //viewAllEmployee(sr);
		    			 break;
		    			 
		    		case 4:
		    			 //updateDepartment(sr);
		    			 break;
		    		
		    		case 5:
		    			 //addNewEmployee(sr);
		    			 break;
		    		
		    		case 6:
		    			//transferemployeetootherdepart(sr);
		    			break;
		    	
		    		case 7: 
		    			//aceeptLeavesOfEmployee(sr);
		    			break;
		    		
		    		case 8:
		    			//rejectLeavesOfEmployee(sr);
		    			break;
		    			
		    		case 9:
		    			 //deleteDepartment(sr);
		    			 break;
		    		
		    		case 10:
		    			 choice = 0;
		    			 break;
		    	
		    		case 0:
		    			  System.out.println("-------------Thanks for Your Visit-------------");
		    			  break;
		    			 
		    		default:
		    			System.out.println("Opps wrong input! please try again");
		    			
		    }
			
		}while(choice!=0);
		
	}

}
