package com.masai.ui;


import java.util.List;
import java.util.Scanner;

import com.masai.color.ConsoleColor;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.LeaveDTO;
import com.masai.dto.LeaveDTOImpl;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;


/**
 * Implementation class for the EmployeeUI interface.
 * Provides the implementation for the employee-related functionality.
 * Extends the EmployeeUI class to inherit the common employee methods.
 * 
 *  @author Km Sakshi
 */
public class EmployeeUIImpl extends EmployeeUI {

	/**
	 * Displays the menu options for updating employee information.
	 * The menu includes options for updating the address, email ID, and password.
	 * The employee can select the desired option to update their information.
	 */
	static void updateMenu() {
		System.out.println("\n");
		System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD+"+--------------------------------------------------+");
		System.out.println("|    Select your choice what you want to update   |");
		System.out.println("+--------------------------------------------------+"+ConsoleColor.RESET);
	    System.out.println("| Press 1: Address                                 |");
	    System.out.println("| Press 2: emailId                                 |");
	    System.out.println("| Press 3: Password                                |");
	    System.out.println("+--------------------------------------------------+");
	}

	
	/**
	 * Displays the profile information of the logged-in employee.
	 * 
	 * Retrieves the employee profile details using the EmployeeDAO and displays them.
	 * 
	 * If an exception occurs, such as NoSuchRecordFoundException or SomthingWentWrongException,
	 * appropriate error messages are displayed.
	 * 
	 *  @param sr The scanner object for user input.
	 */
	@Override
	public void viewYourProfileUI() {
		// String empName = EmployeeUI.getEmpName();

		// Create an instance of EmployeeDAO to access employee data
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			
			// Retrieve the employee's profile using the EmployeeDAO and employee ID
			EmployeeDTO employee = empDAO.viewYourProfile(EmployeeUI.getEmpId());
			
			 // Display the employee's profile information
			System.out.println(employee.toString1());

		} catch (NoSuchRecordFoundException | SomthingWentWrongException e) {
			
			 // Display error messages if an exception occurs during profile retrieval
			 System.out.println(ConsoleColor.RED+"----------------------------------------------------");
  	        System.out.println("No Record Found");
  	        System.out.println(e.getMessage());
  	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
			
		}
	}
	
	
	
	/**
	 * Displays the menu options for updating the employee's profile.
	 * 
	 * Accepts user input for the desired action to be performed.
	 * 
	 * The available options include updating the address, email ID, or password.
	 * 
	 * If the user selects an invalid option, an appropriate error message is displayed.
	 * 
	 * The method loops until a valid option is selected.
	 * 
	 *  @param sr The scanner object for user input.
	 */
	@Override
	public void updateProfileUI(Scanner sr) {
		
		// Display the update menu options
	    EmployeeUIImpl.updateMenu();
	    String choice = "0";
	    do {
	        System.out.print("Enter your selection: ");
	        choice = sr.next();
	        switch (choice) {
	            case "1":   // Display message for the temporarily closed service
	            	System.out.println(ConsoleColor.RED+"----------------------------------------------------");
			        System.out.println("Sorry, this service is temporarily closed.");
			        System.out.println("Please connect with the admin department.");
			        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	                break;
	                
	            case "2":     // Display message for the temporarily closed service
	            	System.out.println(ConsoleColor.RED+"----------------------------------------------------");
			        System.out.println("Sorry, this service is temporarily closed.");
			        System.out.println("Please connect with the admin department.");
			        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	                break;
	                
	            case "3":   // Call the method to change the password
	                changePasswordUI(sr);
	                System.out.println();
	                break;
	                
	            default:    // Display error message for wrong choice
	            	System.out.println(ConsoleColor.RED+"----------------------------------------------------");
			        System.out.println("Opps! Wrong Choice! Please enter the correct choice.");
			        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	        }
	        
	    } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
	}

	
	
	/**
	 * Displays the menu for changing the employee's password.
	 * 
	 * Accepts user input for the old password and the updated password.
	 * 
	 * Calls the EmployeeDAO to change the password in the database.
	 * 
	 * Displays appropriate success or error messages based on the outcome.
	 * 
	 *  @param sr The scanner object for user input.
	 */
	@Override
	public void changePasswordUI(Scanner sr) {
		
		// Display the change password menu
	    System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT+"+--------------------------------------------------+" + ConsoleColor.RESET);
	    System.out.println("|          " + ConsoleColor.YELLOW + "Change Your Password" + ConsoleColor.RESET + "                    |");
	    System.out.println("|--------------------------------------------------|");
	   
	    
	    // Entering for old password and updated password
	    System.out.print("| Please Enter Your old Password : ");
	    String oldPassword = sr.next();
	    System.out.print("| Please Enter Updated Password : ");
	    String updatedPassword = sr.next();
	    System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);
	    
	    
	    // Create an instance of EmployeeDAO to update the password
	    EmployeeDAO empDAO = new EmployeeDAOImpl();
	    
	    
	    try {
	    	
	    	// Call the EmployeeDAO to change the password
	        empDAO.changePassword(oldPassword, updatedPassword, EmployeeUI.getEmpId());
	        System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
	        System.out.println("Update Successful");      // Display success message
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);

	    } catch (NoSuchRecordFoundException | SomthingWentWrongException ex) {
	    	
	    	 // Display error message if an exception occurs
	    	System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	    	System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	        
	    }
	}
	
	
	
	/**
	 * Displays the menu options for selecting a type of leave.
	 * The menu includes options for complementary leave, sick leave, and extra leave.
	 */
	private static void leaveMenu() {
		System.out.println("\n");
	    System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + "+--------------------------------------------------+");
	    System.out.println("|                   Leave Menu                    |");
	    System.out.println("|--------------------------------------------------|"+ConsoleColor.RESET );
	    System.out.println("|  Press 1: for Complementary Leave                |");
	    System.out.println("|  Press 2: for Sick Leave                         |");
	    System.out.println("|  Press 3: for Extra Leave                        |");
	    System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);
	}
	
	
	
	/**
	 * Allows the employee to apply for leave by selecting the type of leave, specifying the number of days,
	 * and providing a reason for the leave.
	 *
	 * The method displays a menu for selecting the type of leave (complementary, sick, or extra) 
	 * and prompts the user to enter the number of days and reason for the leave. 
	 * 
	 * It then creates a LeaveDTO object and calls the appropriate method in the EmployeeDAOImpl class to apply for leave. 
	 * 
	 * If the leave application is successful, a success message is displayed; 
	 * otherwise, an error message is shown.
	 * 
	 *  @param sr The scanner object for user input.
	 */
	@Override
	public void applyforLeaveUI(Scanner sr) {
		System.out.println();
	    System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + "+--------------------------------------------------+");
	    System.out.println("|                   Apply for Leave               |");
	    System.out.println("|--------------------------------------------------|"+ConsoleColor.RESET);
	    
	    int type = 0;
	    EmployeeUIImpl.leaveMenu();
	    String choice = "0";
	    do {
	        System.out.print("Enter type of leave: ");
	        choice = sr.next();
	        switch (choice) {
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
	            	 System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	     	        System.out.println("Wrong input. Please enter a valid choice");
	     	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	        }
	    } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
	    
	    System.out.println("----------------------------------------------------");
	    System.out.print("Enter How Many Days you want to take leave: ");
	    int days_Of_Leave = sr.nextInt();

	    System.out.print("Reason for leave: ");
	    sr.nextLine();      // to take extra input to avoid error 
	    
	    String reason = sr.nextLine();

	    LeaveDTO leave = new LeaveDTOImpl(days_Of_Leave, type, reason);

	    EmployeeDAO empDAO = new EmployeeDAOImpl();
	    try {
	        empDAO.applyForLeave(leave, EmployeeUI.getEmpId());
	        System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
 	        System.out.println("Apply for Leave Successfully");
 	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);

	    } catch (SomthingWentWrongException ex) {
	    	System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	    	System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	       // System.out.println(ConsoleColor.RED + ex + ConsoleColor.RESET);
	    }
	    System.out.println();
	}

	@Override
	void leaveStatus(Scanner sr) {
		System.out.println();
		 System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + "+--------------------------------------------------+");
		    System.out.println("|          Recent Leave Request Status            |");
		    System.out.println("|--------------------------------------------------|"+ConsoleColor.RESET);

		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			LeaveDTO empLeave = empDAO.leaveStatus(EmployeeUI.getEmpId());
			System.out.println(empLeave.toString1()); // need to work on
			Thread.sleep(1000);

		} catch (NoSuchRecordFoundException | SomthingWentWrongException | InterruptedException ex) {
			System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	    	System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
			//System.out.println(ex);
		}

		System.out.println();

	}
	
	
	
	/**
	 * Retrieves and displays the recent leave record of an employee.
	 *
	 * This method interacts with the EmployeeDAOImpl class to retrieve the leave record of the employee.
	 * 
	 * It displays the leave record in a formatted table, including employee ID, employee name, days of leave,
	 * leave type, reason, date, and status.
	 *
	 * If the leave record is found and displayed successfully, it indicates the recent leave history of the employee.
	 * 
	 * 
	 * If an exception occurs or no record is found, it prints an error message to notify the user.
	 * 
	 *  @param sr The scanner object for user input.
	 */
	@Override
	public void recordOfLeaveUI(Scanner sr) {
		System.out.println();

		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			
			List<LeaveDTO> list = empDAO.recordOfLeave(EmployeeUI.getEmpId());
			System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT +"+------------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                                      Recent Leaves Record                                 |");
			System.out.println("+-----------+------------------+------------------+----------+------------------+---------------+------------+"+ConsoleColor.RESET);
			System.out.println("|  empId    |     empName      |   days_of_leave  |   type   |      reason      |     date      |   status   |");
			System.out.println("+-----------+------------------+------------------+----------+------------------+---------------+------------+");
			
			// Displaying each leave record using stream
			list.stream().forEach(System.out::println); // need to work on it
			
		} catch (NoSuchRecordFoundException | SomthingWentWrongException ex) {
			System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	    	System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
			//System.out.println(ex.getMessage());
		}

		//System.out.println();
	}

	
	
	/**
	 * Displays the monthly salary status of an employee.
	 * 
	 * This method interacts with the EmployeeDAOImpl class to retrieve the total salary of the employee for the current month.
	 * 
	 * It displays the salary amount with a success message. 
	 * 
	 * If any exception occurs during the process, it prints an error message in red color to notify the user.
	 *
	 * @param sr The scanner object for user input.
	 */
	@Override
	void totalSalaryMonthUI(Scanner sr) {
		System.out.println();

		 System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT  + "+--------------------------------------------------+");
		    System.out.println("|                Month Salary Status              |");
		    System.out.println("|--------------------------------------------------|"+ConsoleColor.RESET);
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			double salary = empDAO.totalSalaryOfMonth(EmployeeUI.getEmpId());
			System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
			System.out.println("The Month Salary : " + salary);
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
			 // need to
			// work on
			// it
			Thread.sleep(1000);
		} catch (SomthingWentWrongException | InterruptedException ex) {
			System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	    	System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
			//System.out.println(ex);
		}

		System.out.println("");

	}

	
	/**
	 * Displays the annual salary record of an employee.
	 *
	 * This method interacts with the EmployeeDAOImpl class to retrieve the total annual salary of the employee.
	 * 
	 * It displays the salary amount with a success message. 
	 * 
	 * If any exception occurs during the process, it prints an error message to notify the user.
	 * 
	 *  @param sr The scanner object for user input.
	 */
	@Override
	public void totalSalaryAnnualyUI(Scanner sr) {
		System.out.println();
		 System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT  + "+--------------------------------------------------+");
		    System.out.println("|        Annual Salary Record of Employee         |");
		    System.out.println("|--------------------------------------------------|"+ConsoleColor.RESET);

		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			double salary = empDAO.totalSalaryAnnualy(EmployeeUI.getEmpId());
			System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
			System.out.println("The Annual Salary : " + salary);
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
			 // need to
			// work on
			// it

		} catch (SomthingWentWrongException ex) {
			System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	    	System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
			//System.out.println(ex);
		}

		System.out.println();

	}

}
