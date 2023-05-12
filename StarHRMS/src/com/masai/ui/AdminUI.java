package com.masai.ui;


import java.util.Scanner;

import com.masai.color.ConsoleColor;


/**
 * The AdminUI abstract class defines the interface for the administrative user interface.
 * 
 * It provides methods to perform various administrative tasks such as managing departments, employees,
 * leaves, and other related operations. 
 * 
 * Concrete implementations of this class are expected to
 * provide the implementation details for these methods based on the specific requirements of the system.
 * 
 *  @author Km Sakshi
 */
public abstract class AdminUI {
	private static boolean login = false;

	public static boolean isLogin() {
		return login;
	}

	/**
	 * Displays the Admin Login user interface and handles the login process
	 * @param sr the Scanner object used for user input
	 * @throws InterruptedException if the thread is interrupted while sleeping
	 */
	static void adminLogInUI(Scanner sr) throws InterruptedException {
		System.out.println("\n");
		System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD+"+--------------------------------------------------+");
		System.out.println("|                 LogIn To Admin                  |");
		System.out.println("+--------------------------------------------------+"+ConsoleColor.RESET);
	    int i = 0;
	    String choice = "0";
	    do {
	        System.out.print("Enter Your Username: ");
	        String username = sr.next();
	        System.out.print("Enter Your Password: ");
	        String password = sr.next();
	        if (username.equals("Admin") && password.equals("Admin")) {
	        	System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
    	        System.out.println("Login Successfully!");
    	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	            login = true;
	            Thread.sleep(1000);
	            System.out.println("\n");
	            AdminUI.admin(sr);
	            break;
	        } else {
	            System.out.println(ConsoleColor.RED+"----------------------------------------------------");
    	        System.out.println("Opps! Wrong Credentials, please try again!");
    	        System.out.println("----------------------------------------------------\n"+ConsoleColor.RESET);
	            if (i != 3) {
	                System.out.println("+--------------------------------------------------+");
	                System.out.println("| Press 1: Try Again                               |");
	                System.out.println("| Press 0: Go Back                                 |");
	                System.out.println("+--------------------------------------------------+");
	                do {
	                    System.out.print("Enter your choice: ");
	                    choice = sr.next();
	                    if (!choice.equals("1") && !choice.equals("0")) {
	                    	System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	            	        System.out.println("Opps! Wrong input, please try again!");
	            	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	                 
	                    }
	                } while (!choice.equals("1") && !choice.equals("0"));
	                i++;
	            }
	        }
	    } while (i != 3 && !choice.equals("0"));
	    if(i==3) {
	    	System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	        System.out.println("Already Tried Three Times!");
	        System.out.println(ConsoleColor.GREEN + "\nPlease Visit after Some Time"+ConsoleColor.RESET);
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
            
	    }
	}
	
	
	
	/**
	 * Displays the menu options for the admin dashboard.
	 * The menu includes various administrative tasks that an admin can perform such as
	 * adding new departments, viewing departments and employees, updating departments,
	 * adding new employees, transferring employees to other departments, accepting or rejecting
	 * employee leaves, firing employees, deleting departments, and exiting the admin dashboard.
	 *
	 * @throws InterruptedException if there is an interruption while waiting.
	 */
	static void adminMenu() throws InterruptedException {
		System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD+"+--------------------------------------------------+");
		System.out.println("|                 Admine DashBord                 |");
		System.out.println("+--------------------------------------------------+"+ConsoleColor.RESET);
		
	    System.out.println("| Press 1 : Add New Department                     |");
	    System.out.println("| Press 2 : View All The Departments               |");
	    System.out.println("| Press 3 : View All The Employees                 |");
	    System.out.println("| Press 4 : Update The Department                  |");
	    System.out.println("| Press 5 : Add New Employee                       |");
	    System.out.println("| Press 6 : Transfer Employee to Other Department  |");
	    System.out.println("| Press 7 : Accept/Reject Leaves of Employees      |");
	    System.out.println("| Press 8 : Fire An Employee                       |");
	    System.out.println("| Press 9 : Delete Department                      |");
	    System.out.println("| Press 0 : Exit -OR- Go Back To Home              |");
	    System.out.println("+--------------------------------------------------+");
	}

	
	/**
	 * Prompts the user to enter details for adding a new department
	 * @param sr the Scanner object to read user input
	 */
	abstract void addNewDepartmentUI(Scanner sr);

	
	/**
	 * Displays all the departments.
	 */
	abstract void viewAllDepartmentUI();

	
	/**
	 * Prompts the user to enter criteria for viewing all employees
	 * @param sr the Scanner object to read user input
	 */
	abstract void viewAllEmployeeUI(Scanner sr);

	
	/**
	 * Prompts the user to enter details for updating a department
	 * @param sr the Scanner object to read user input
	 */
	abstract void updateDepartmentUI(Scanner sr);

	
	/**
	 * Prompts the user to enter details for adding a new employee
	 * @param sr the Scanner object to read user input
	 */
	abstract void addNewEmployeeUI(Scanner sr);

	
	/**
	 * Prompts the user to enter details for transferring an employee to another department
	 * @param sr the Scanner object to read user input
	 */
	abstract void transferemployeetootherdepartUI(Scanner sr);

	
	/**
	 * Prompts the user to accept or reject leaves of an employee
	 * @param sr the Scanner object to read user input
	 */
	abstract void aceeptOrRejectLeavesOfEmployeeUI(Scanner sr);

	
	/**
	 * Prompts the user to enter details for firing an employee
	 * @param sr the Scanner object to read user input
	 */
	abstract void fireEmployeeUI(Scanner sr);

	
	/**
	 * Prompts the user to enter details for deleting a department
	 * @param sr the Scanner object to read user input
	 */
	abstract void deleteDepartmentUI(Scanner sr);

	
	
	/**
	 * Handles the admin functionality in the application.
	 * Allows admin to perform various actions based on their selection.
	 * @param sr Scanner object to read user input
	 * @throws InterruptedException if there is an interruption while sleeping the thread
	 */
	static void admin(Scanner sr) throws InterruptedException {
		String choice = "0";
		while (login) {
			adminMenu();       // Display the admin menu
			AdminUI adminUI = new AdminUIImpl();
			System.out.print("Enter your selection : ");
			choice = sr.next();
			System.out.println();
			switch (choice) {
			case "1":
				adminUI.addNewDepartmentUI(sr);    // Add a new department
				System.out.println();
				break;

			case "2":
				adminUI.viewAllDepartmentUI();    // View all departments
				System.out.println();
				break;

			case "3":
				adminUI.viewAllEmployeeUI(sr);   // View all employees
				System.out.println();
				break;

			case "4":
				adminUI.updateDepartmentUI(sr);   // Update department details
				System.out.println();
				break;

			case "5":
				adminUI.addNewEmployeeUI(sr);      // Add a new employee
				System.out.println();
				break;

			case "6":
				adminUI.transferemployeetootherdepartUI(sr);   // Transfer an employee to another department
				System.out.println();
				break;

			case "7":
				adminUI.aceeptOrRejectLeavesOfEmployeeUI(sr);   // Accept or reject employee leaves
				System.out.println();
				break;

			case "8":
				adminUI.fireEmployeeUI(sr);    // Fire an employee
				System.out.println();
				break;

			case "9":
				adminUI.deleteDepartmentUI(sr);    // Delete a department
				System.out.println();  
				break;

			case "0":
				System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
		        System.out.println("Thanks For Your Visit!");
		        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
				login = false;    // Exit the loop and end the program
				break;

			default:
				System.out.println(ConsoleColor.RED+"----------------------------------------------------");
		        System.out.println("Oops! Try again with a valid selection!");
		        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);

			}
			Thread.sleep(1000);  // Pause for 1 second before displaying the menu again
		}
	}

}
