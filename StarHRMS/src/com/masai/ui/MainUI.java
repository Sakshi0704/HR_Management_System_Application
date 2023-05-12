package com.masai.ui;

import java.util.Scanner;
import com.masai.color.ConsoleColor;

public class MainUI {

	static void adminLink(Scanner sr) throws InterruptedException {
		String choice = "0";
		do {
			System.out.println("\n");
			System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
					+ "+--------------------------------------------------+");
			System.out.println("|              LogIn To Admin Panel               |");
			System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);

			System.out.println("+--------------------------------------------------+");
			System.out.println("| Press 1: LogIn To Admin Panel                    |");
			System.out.println("| Press 0: Go back to Home Page                    |");
			System.out.println("+--------------------------------------------------+");
			System.out.print("Enter your selection: ");
			choice = sr.next();
			switch (choice) {
			case "1":
				AdminUI.adminLogInUI(sr);
				break;
			case "0":
				System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
				System.out.println("Thanks For Visiting!");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
				break;
			default:
				System.out.println(ConsoleColor.RED + "----------------------------------------------------");
				System.out.println("Oops! Try again with a valid selection");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
			}
		} while (!choice.equals("0"));
		System.out.println();
	}

	static void employeeLink(Scanner sr) {
		String choice = "0";
		do {
			System.out.println("\n");
			System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
					+ "+--------------------------------------------------+");
			System.out.println("|              LogIn To Employee Page             |");
			System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);

			System.out.println("+--------------------------------------------------+");
			System.out.println("| Press 1: LogIn To Employee Page                  |");
			System.out.println("| Press 0: Go back to Home Page                    |");
			System.out.println("+--------------------------------------------------+");
			System.out.print("Enter your selection: ");
			choice = sr.next();
			switch (choice) {
			case "1":
				EmployeeUI.empLogInUI(sr);
				break;
			case "0":
				System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
				System.out.println("Thanks For Visiting!");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
				break;
			default:
				System.out.println(ConsoleColor.RED + "----------------------------------------------------");
				System.out.println("Oops! Try again with a valid selection");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
			}
		} while (!choice.equals("0"));
		System.out.println("");

	}

	public static void main(String args[]) throws InterruptedException {
		Scanner sr = new Scanner(System.in);
		System.out.println("");
		System.out.println(ConsoleColor.FOREST_GREEN_BACKGROUND + ConsoleColor.BLACK_BOLD
				+ "+--------------------------------------------------+");
		System.out.println("|                    WELCOME                      |");
		System.out.println("|          StarHR Management System               |");
		System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);

		String choice = "0";
		do {
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
			choice = sr.next();
			switch (choice) {
			case "1":
				adminLink(sr);
				break;
			case "2":
				employeeLink(sr);
				break;
			case "0":
				System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
				System.out.println("Thanks For Visiting!");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
				break;
			default:
				System.out.println(ConsoleColor.RED + "----------------------------------------------------");
				System.out.println("Oops! Try again with a valid selection");
				System.out.println("----------------------------------------------------" + ConsoleColor.RESET);
				Thread.sleep(1000);
				break;
			}

		} while (!choice.equals("0"));

		System.out.println("");

		sr.close();

	}

}