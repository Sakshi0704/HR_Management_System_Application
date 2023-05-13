package com.masai.ui;

import java.util.Scanner;
import com.masai.color.ConsoleColor;

public class MainUI {

	/**
	 * Displays the login screen for the admin panel and handles the user's input.
	 *
	 * @param sr The Scanner object used to read user input.
	 * 
	 * @throws InterruptedException If there is an interruption during thread execution.
	 */
	static void adminLink(Scanner sr) throws InterruptedException {
		String choice = "0";
		do {
			// Print the login screen header
			System.out.println("\n");
			System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
					+ "+--------------------------------------------------+");
			System.out.println("|              LogIn To Admin Panel               |");
			System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);

			// Display the available options
			System.out.println("+--------------------------------------------------+");
			System.out.println("| Press 1: LogIn To Admin Panel                    |");
			System.out.println("| Press 0: Go back to Home Page                    |");
			System.out.println("+--------------------------------------------------+");
			System.out.print("Enter your selection: ");
			
			
			// Read the user's input
			choice = sr.next();
			
			
			 // Process the user's choice
			switch (choice) {
			case "1":
				// Call the admin login method from the AdminUI class
				AdminUI.adminLogInUI(sr);
				break;
			case "0":
				// Display a farewell message and exit the loop
				System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
				System.out.println("Thanks For Visiting!");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
				break;
			default:
				// Display an error message for an invalid selection
				System.out.println(ConsoleColor.RED + "----------------------------------------------------");
				System.out.println("Oops! Try again with a valid selection");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
			}
		} while (!choice.equals("0"));
		System.out.println();
	}

	
	/**
	 * Displays the login screen for the employee page and handles the user's input.
	 *
	 * @param sr The Scanner object used to read user input.
	 */
	static void employeeLink(Scanner sr) {
		String choice = "0";
		do {
			// Display the login screen header
			System.out.println("\n");
			System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
					+ "+--------------------------------------------------+");
			System.out.println("|              LogIn To Employee Page             |");
			System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);

			// Display the available options
			System.out.println("+--------------------------------------------------+");
			System.out.println("| Press 1: LogIn To Employee Page                  |");
			System.out.println("| Press 0: Go back to Home Page                    |");
			System.out.println("+--------------------------------------------------+");
			System.out.print("Enter your selection: ");
			
			
			// Read the user's input
			choice = sr.next();
			
			// Process the user's choice
			switch (choice) {
			case "1":
				// Call the employee login method from the EmployeeUI class
				EmployeeUI.empLogInUI(sr);
				break;
			case "0":
				// Display a farewell message and exit the loop
				System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
				System.out.println("Thanks For Visiting!");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
				break;
			default:
				// Display an error message for an invalid selection
				System.out.println(ConsoleColor.RED + "----------------------------------------------------");
				System.out.println("Oops! Try again with a valid selection");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
			}
		} while (!choice.equals("0"));
		System.out.println("");

	}

	
	
	/**
	 * The main method of the StarHR Management System program.
	 * 
	 * It displays the welcome message and provides a menu for users to choose 
	 * between the admin page, employee page, or exiting the program.
	 *
	 * @param args The command-line arguments passed to the program.
	 * 
	 * @throws InterruptedException If there is an interruption during thread execution.
	 */
	public static void main(String args[]) throws InterruptedException {
		
		// Create a Scanner object to read user input
		Scanner sr = new Scanner(System.in);
		
		// Display the welcome message and system title
		System.out.println("");
		System.out.println(ConsoleColor.FOREST_GREEN_BACKGROUND + ConsoleColor.BLACK_BOLD
				+ "+--------------------------------------------------+");
		System.out.println("|                    WELCOME                      |");
		System.out.println("|          StarHR Management System               |");
		System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);

		String choice = "0";
		do {
			// Display the menu options
			System.out.println("\n");
			System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
					+ "+--------------------------------------------------+");
			System.out.println("|              WHERE YOU WANT TO VISIT            |");
			System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);
			System.out.println("| Press 1: Admin Page                              |");
			System.out.println("| Press 2: Employee Page                           |");
			System.out.println("| Press 0: Exit                                    |");
			System.out.println("+--------------------------------------------------+");
			System.out.print("Enter your selection: ");
			
			// Read the user's input
			choice = sr.next();
			
			// Process the user's choice
			switch (choice) {
			case "1":
				// Call the adminLink method to navigate to the admin page
				adminLink(sr);
				break;
			case "2":
				// Call the employeeLink method to navigate to the employee page
				employeeLink(sr);
				break;
			case "0":
				// Display a farewell message and exit the program
				System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
				System.out.println("Thanks For Visiting!");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
				break;
			default:
				// Display an error message for an invalid selection and wait for 1 second before displaying the menu again
				System.out.println(ConsoleColor.RED + "----------------------------------------------------");
				System.out.println("Oops! Try again with a valid selection");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
				Thread.sleep(1000);
				break;
			}

		} while (!choice.equals("0"));

		System.out.println("");

		// Close the Scanner object
		sr.close();

	}

}