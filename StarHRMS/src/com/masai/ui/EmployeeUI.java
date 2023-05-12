package com.masai.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.masai.color.ConsoleColor;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

/**
 * Abstract class representing the User Interface for an employee. Provides the
 * basic structure and common methods for employee-related UI classes.
 * 
 * @author Km Sakshi
 */
public abstract class EmployeeUI {

	private static int empId;
	private static String empName;
	private static boolean logIn = false;

	/**
	 * Displays the menu options for the employee dashboard.
	 * 
	 * The menu includes various actions that an employee can perform such as
	 * viewing profile, updating profile and password, applying for leave, checking
	 * leave status, viewing leave records, calculating monthly and yearly salary,
	 * and logging out.
	 */
	private static void employeeMenu() {
		System.out.println("\n");
		System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
				+ "+---------------------------------------------------+");
		System.out.println("|                Employee Dashboard                |");
		System.out.println("+---------------------------------------------------+" + ConsoleColor.RESET);
		System.out.println("|  Press 1: View Your Profile                       |");
		System.out.println("|  Press 2: Update Profile and Change Your Password |");
		System.out.println("|  Press 3: Apply for Leave                         |");
		System.out.println("|  Press 4: Leave Status                            |");
		System.out.println("|  Press 5: Record of Leave                         |");
		System.out.println("|  Press 6: Total Salary Of A Month                 |");
		System.out.println("|  Press 7: Total Salary Of A Financial Year        |");
		System.out.println("|  Press 0: Log Out (Go Back To Home)               |");
		System.out.println("+---------------------------------------------------+");
		System.out.println(ConsoleColor.RESET);
	}

	/**
	 * Displays the employee login panel and handles the authentication process.
	 * 
	 * Prompts the user to enter their email ID and password, and validates the
	 * credentials using the EmployeeDAO.
	 * 
	 * If the credentials are valid, the user is logged in and the employee
	 * dashboard is displayed.
	 * 
	 * If the credentials are invalid, an appropriate error message is displayed.
	 *
	 * @param sr the Scanner object used for user input.
	 */
	static void empLogInUI(Scanner sr) {
		System.out.println("\n");
		System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
				+ "+--------------------------------------------------+");
		System.out.println("|               Employee Login Panel              |");
		System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);

		System.out.print("| Enter Your Username (EmailID): ");
		String emailId = sr.next();
		System.out.print("| Enter Your Password: ");
		String password = sr.next();
		System.out.println("+--------------------------------------------------+");

		List<String> list = new ArrayList<>();
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			list = empDAO.empLogIn(emailId, password);
			empId = Integer.parseInt(list.get(0));
			empName = list.get(1);
			logIn = true;
			System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
			System.out.println("LogIn Successful");
			System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
			employee(sr);
		} catch (WrongCredentialsException | SomthingWentWrongException e) {
			System.out.println(ConsoleColor.RED + "----------------------------------------------------");
			System.out.println("Thanks For Your Visit!");
			System.out.println(e.getMessage());
			System.out.println("----------------------------------------------------" + ConsoleColor.RESET);

		}
	}

	/**
	 * Displays the user's profile information.
	 */
	abstract void viewYourProfileUI();

	/**
	 * Allows the user to update their profile information.
	 * 
	 * @param sr the Scanner object used for user input.
	 */
	abstract void updateProfileUI(Scanner sr);

	/**
	 * Allows the user to change their password.
	 * 
	 * @param sr the Scanner object used for user input.
	 */
	abstract void changePasswordUI(Scanner sr);

	/**
	 * Allows the user to apply for leave.
	 * 
	 * @param sr the Scanner object used for user input.
	 */
	abstract void applyforLeaveUI(Scanner sr);

	/**
	 * Displays the leave status of the user.
	 * 
	 * @param sr the Scanner object used for user input.
	 */
	abstract void leaveStatus(Scanner sr);

	/**
	 * Displays the record of leave for the user.
	 * 
	 * @param sr the Scanner object used for user input.
	 */
	abstract void recordOfLeaveUI(Scanner sr);

	/**
	 * Displays the total salary for the current month.
	 * 
	 * @param sr the Scanner object used for user input.
	 */
	abstract void totalSalaryMonthUI(Scanner sr);

	/**
	 * Displays the total salary for the current financial year.
	 * 
	 * @param sr the Scanner object used for user input.
	 */
	abstract void totalSalaryAnnualyUI(Scanner sr);

	/**
	 * Retrieves the employee ID.
	 * 
	 * @return The employee ID
	 */
	public static int getEmpId() {
		return empId;
	}

	/**
	 * Retrieves the employee name.
	 * 
	 * @return The employee name
	 */
	public static String getEmpName() {
		return empName;
	}

	/**
	 * Checks if the employee is currently logged in.
	 * 
	 * @return True if the employee is logged in, false otherwise
	 */
	public static boolean isLogIn() {
		return logIn;
	}

	/**
	 * Handles the employee functionality in the application. Allows employees to
	 * perform various actions based on their selection.
	 * 
	 * @param sr Scanner object to read user input
	 */
	static void employee(Scanner sr) {
		String choice = "";
		while (logIn) {
			EmployeeUI employee = new EmployeeUIImpl();
			employeeMenu(); // Display the employee menu
			System.out.print("Enter your selection: ");
			choice = sr.next();

			try {
				switch (choice) {
				case "1":
					employee.viewYourProfileUI(); // View employee's profile
					System.out.println();
					Thread.sleep(1000);
					break;

				case "2":
					employee.updateProfileUI(sr); // Update employee's profile
					System.out.println();
					Thread.sleep(1000);
					break;
				case "3":
					employee.applyforLeaveUI(sr); // Apply for leave
					System.out.println();
					Thread.sleep(1000);
					break;

				case "4":
					employee.leaveStatus(sr); // Check leave status
					System.out.println();
					Thread.sleep(1000);
					break;

				case "5":
					employee.recordOfLeaveUI(sr); // View record of leave
					System.out.println();
					Thread.sleep(1000);
					break;

				case "6":
					employee.totalSalaryMonthUI(sr); // Calculate total salary for the month
					System.out.println();
					Thread.sleep(1000);
					break;

				case "7":
					employee.totalSalaryAnnualyUI(sr); // Calculate total salary for the year
					System.out.println();
					Thread.sleep(1000);
					break;

				case "0":
					System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
					System.out.println("Thanks For Your Visit!");
					System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
					System.out.println();
					logIn = false; // Exit the loop and end the program
					break;

				default:
					System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
					System.out.println("Oops! Try again with a valid selection");
					System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
					System.out.println();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
