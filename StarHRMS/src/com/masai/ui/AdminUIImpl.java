package com.masai.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.masai.color.ConsoleColor;
import com.masai.dao.AdminDAO;
import com.masai.dao.AdminDAOImpl;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.dao.LeaveDAO;
import com.masai.dto.DepartmentDTO;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.EmployeeDTOImpl;
import com.masai.dto.LeaveDTO;


/**
 * Implementation class for the AdminUI interface.
 * Provides the implementation for the admin-related functionality.
 * Extends the AdminUI class to inherit the common admin methods.
 * @author Km Sakshi
 */
public class AdminUIImpl extends AdminUI {

	
	/**
	 * Displays the user interface for adding a new department.
	 *
	 * This method prompts the user to enter the details of the new department, including the department ID and name.
	 * 
	 * It interacts with the AdminDAOImpl class to add the new department to the record. 
	 * 
	 * If the addition is successful, it displays a success message. 
	 * 
	 * Otherwise, it prints an error message in red color along with the exception message to notify the user.
	 *
	 * @param sr The scanner object for user input.
	 */
	@Override
	void addNewDepartmentUI(Scanner sr) {
	    System.out.println("");
	    System.out.println("----------------------------------------------------");
	    System.out.println("Enter New Department Details To Add In Record");
	    System.out.println("----------------------------------------------------");

	    System.out.print("Enter New Department ID: ");
	    String deptId = sr.next();
	   // sr.nextLine();
	    System.out.print("Enter New Department Name: ");
	    sr.nextLine();    // take the newline character to avoid error 
	    String deptName = sr.nextLine(); 

	    AdminDAO adminDAO = new AdminDAOImpl();

	    try {
	        adminDAO.addNewDepartment(deptId, deptName);
	        System.out.println(ConsoleColor.GREEN + "----------------------------------------------------");
	        System.out.println("Add New Department Successfully!");
	        System.out.println("----------------------------------------------------"+ ConsoleColor.RESET);
	    } catch (Exception ex) {
	        System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	        System.out.println("Unable to add new Department!");
	        System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ ConsoleColor.RESET);
	        
	    }

	    System.out.println("\n");
	}
	
	
	
	
	/**
	 * Displays the user interface for viewing all department details.
	 *
	 * This method interacts with the AdminDAOImpl class to retrieve a list of all department details.
	 * It then prints the department ID and name for each department in a formatted table.
	 *
	 * If there are no department records or an exception occurs during retrieval, 
	 * an error message is displayed along with the exception message.
	 *
	 */
	@Override
	void viewAllDepartmentUI() {

		AdminDAO adminDAO = new AdminDAOImpl();

		try {
			List<DepartmentDTO> list = adminDAO.viewAllDepartment();
			System.out.println("");
			System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
					+ "+-------------------------------------------------------+");
			System.out.println("|              All Department Details                  |");
			System.out.println("+-------------------------------------------------------+" + ConsoleColor.RESET);

			System.out.println("|        deptID           |         deptName            |");
			System.out.println("+-------------------------+-----------------------------+");

			list.stream().forEach(System.out::println);
		} catch (Exception ex) {
			 System.out.println(ConsoleColor.RED+"\n+--------------------------------------------------+");
		     System.out.println("| No Record Found        |");
		     System.out.println(ex.getMessage());
		     System.out.println("+--------------------------------------------------+"+ ConsoleColor.RESET);
			
		}

	}

	
	
	/**
	 * Displays the user interface for viewing all employee details.
	 *
	 * This method interacts with the AdminDAOImpl class to retrieve a list of all employee details.
	 * 
	 * It then prints the employee ID, name, email, password, address, salary, department ID, department name,
	 * and department date of each employee in a formatted table.
	 *
	 * If there are no employee records or an exception occurs during retrieval, 
	 * an error message is displayed with the exception message.
	 *
	 * @param sr The Scanner object used for user input.
	 */
	@Override
	void viewAllEmployeeUI(Scanner sr) {

		AdminDAO adminDAO = new AdminDAOImpl();

		try {
			List<EmployeeDTO> list = adminDAO.viewAllEmployee();
			System.out.println("");
			System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
					+ "+-----------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println(
					"|                                                       All Employee Details                                                                   |");
			System.out.println(
					"+-----------------------------------------------------------------------------------------------------------------------------------------------+"
							+ ConsoleColor.RESET);

			System.out.println(
					"+---------+------------------+------------------+------------------+------------------+-----------+----------+-----------------+----------------+");
			System.out.println(
					"|  empId  |      empName     |      email       |     password     |   empAddress     |   salary  |  deptId  |    deptName     |    deptDate    |");
			System.out.println(
					"+---------+------------------+------------------+------------------+------------------+-----------+----------+-----------------+----------------+");
			list.stream().forEach(System.out::println);

		} catch (Exception ex) {
			 System.out.println(ConsoleColor.RED+"\n+--------------------------------------------------+");
		     System.out.println("| No Record Found       ");
		     System.out.println(ex.getMessage());
		     System.out.println("+--------------------------------------------------+"+ ConsoleColor.RESET);
		}

	}
	
	
	
	/**
	 * Displays the menu for updating department details.
	 * 
	 * The menu includes options for updating the department ID, department name, 
	 * or all details of a department.
	 * 
	 * It also provides an option to exit or go back.
	 *
	 */
	private static void updateMenu() {
		System.out.println("");
		System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT + ConsoleColor.BLACK_BOLD
				+ "+--------------------------------------------------+");
		System.out.println("|                Update Department Menu           |");
		System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);
		System.out.println("+--------------------------------------------------+");
		System.out.println("|         Option      |          Description       |");
		System.out.println("+--------------------------------------------------+");

		System.out.println("|           1         |     Update Department ID   |");
		System.out.println("|           2         |    Update Department Name  |");
		System.out.println("|           3         |      Update All Details    |");
		System.out.println("|           0         |        Exit / Go Back      |");
		System.out.println("+--------------------------------------------------+");
		System.out.println("");
	}

	
	
	
	/**
	 * Displays the update department user interface.
	 *
	 * This method presents a menu to the user for updating department details. 
	 * 
	 * The user is prompted to choose an option from the menu by entering a corresponding number. 
	 * 
	 * The options include updating the department ID, department name,or all details of a department. 
	 * 
	 * If the user selects option 3, the 'updateDepartmentAllDetailsUI' method is called to handle the update process.
	 * Only this option is working currently
	 * 
	 * Selecting option 0 allows the user to exit or go back to the previous menu.
	 * 
	 * Invalid selections prompt the user to try again with a valid option.
	 *
	 * This method uses the 'updateMenu' method from the 'AdminUIImpl' class to display the menu.
	 */
	@Override
	void updateDepartmentUI(Scanner sr) {
		String choice = "0";
		do {
			AdminUIImpl.updateMenu();
			System.out.print("Enter your selection: ");
			choice = sr.next();
			switch (choice) {
			case "1":
				System.out.println(ConsoleColor.YELLOW + "+--------------------------------------------------+");
				System.out.println("|      Sorry, this service is temporarily          |");
				System.out.println("|           closed. Please choose                  |");
				System.out.println("|             option 3 to update                   |");
				System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);
				break;
			case "2":
				System.out.println(ConsoleColor.YELLOW + "+--------------------------------------------------+");
				System.out.println("|      Sorry, this service is temporarily          |");
				System.out.println("|           closed. Please choose                  |");
				System.out.println("|             option 3 to update                   |");
				System.out.println("+--------------------------------------------------+" + ConsoleColor.RESET);
				break;
			case "3":
				updateDepartmentAllDetailsUI(sr);
				break;
			case "0":
				 System.out.println( ConsoleColor.GREEN +"\n--------------------------------------------------");
			     System.out.println("Thanks For Your Visit!        ");
			     System.out.println("--------------------------------------------------"+ ConsoleColor.RESET);
				break;
			default:
				System.out.println( ConsoleColor.RED +"\n--------------------------------------------------");
				System.out.println("Oops! Try again with a valid selection!        ");
				System.out.println("--------------------------------------------------"+ ConsoleColor.RESET);
			}
			
		} while (!choice.equals("0"));

	}

	
	
	/**
	 * Displays the update department details user interface.
	 *
	 * This method prompts the user to enter the current department ID (created by the admin) that needs to be updated.
	 * 
	 * Then, it asks for the updated department ID and department name.
	 * 
	 * The user's input is used to update the department details using the 'updateDepartmentAllDetails' method
	 * from the 'AdminDAO' implementation.
	 * 
	 * If the update is successful, a success message is displayed.
	 * 
	 * If an exception occurs during the update process, an error message is displayed.
	 *
	 * Note: The department ID provided should match the existing department ID created by the admin.
	 * 
	 * If the department ID is not valid, the update will fail.
	 * 
	 * 
	 */
	void updateDepartmentAllDetailsUI(Scanner sr) {
	    System.out.println("");
	    System.out.println("+--------------------------------------------------+");
	    System.out.println("|              Update Department Details          |");
	    System.out.println("+--------------------------------------------------+");

	    System.out.print("Enter Current Department Id (Created By Admin (deptId)): ");
	    String oldDeptID = sr.next();

	    System.out.println("\nEnter Updated Department Details");
	    System.out.println("------------------------------");

	    System.out.print("Enter Updated Department ID (Created By Admin (deptId)): ");
	    String deptId = sr.next();

	    System.out.print("Enter Updated Department Name: ");
	    sr.nextLine();              // Consume the extra character before
	    String deptName = sr.nextLine();

	    AdminDAO adminDAO = new AdminDAOImpl();

	    try {
	        adminDAO.updateDepartmentAllDetails(oldDeptID, deptId, deptName);
	        System.out.println(ConsoleColor.GREEN+"\n+--------------------------------------------------+");
	        System.out.println("|   Updated Department Successfully             |");
	        System.out.println("+--------------------------------------------------+"+ConsoleColor.RESET);
	    } catch (Exception ex) {
	        System.out.println(ConsoleColor.RED+"\n+--------------------------------------------------+");
	        System.out.println("| Unable to Update Department Successfully        |");
	        System.out.println(ex.getMessage());
	        System.out.println("+--------------------------------------------------+"+ConsoleColor.RESET);
	    }
	}


	
	
	/**
	 * To add new employee details.
	 *
	 * This method prompts the user to enter the new employee details 
	 * such as employee ID, name, email, address, joining date,
	 * salary, and department ID (created by admin).
	 * 
	 * The user's input is used to create an EmployeeDTO object and pass it to the 'addNewEmployee' method in the 'AdminDAO'
	 * implementation along with the department ID.
	 * 
	 * If the employee addition is successful, a success message is displayed.
	 * 
	 * If an exception occurs during the process, an error message is displayed.
	 *
	 * Note: The employee ID and department ID provided should be unique and match the existing IDs in the records.
	 * 
	 * If there is a conflict with the ID, the addition will fail.
	 * 
	 */
	@Override
	void addNewEmployeeUI(Scanner sr) {
		System.out.println("");
	    System.out.println("----------------------------------------------------");
	    System.out.println("Enter New Employee Details To Add In Record");
	    System.out.println("----------------------------------------------------");
	   

	    EmployeeDTO employee = new EmployeeDTOImpl();
	    System.out.print("Enter Unique Employee ID: ");
	    employee.setEmpId(sr.next());

	    System.out.print("Enter Employee Name: ");
	    sr.nextLine();      // Consume the extra character before
	    employee.setEname(sr.nextLine());

	    System.out.print("Enter Unique Employee Email: ");
	    employee.setEmail(sr.next());

	    System.out.print("Enter Employee Address: ");
	    sr.nextLine();      // Consume the extra character before
	    employee.setEmpAddress(sr.nextLine());

	    System.out.print("Enter Employee Joining Date (yyyy-mm-dd): ");
	    try {
	        employee.setDate(LocalDate.parse(sr.next()));
	    } catch (Exception ex) {
	        System.out.println(ex.getMessage());
	    }

	    System.out.print("Enter Employee Salary Per Month: ");
	    employee.setSalary(sr.nextDouble());

	    System.out.print("Enter Department ID (Created By Admin): ");
	    String deptID = sr.next();

	    AdminDAO adminDAO = new AdminDAOImpl();

	    try {
	    	adminDAO.addNewEmployee(employee, deptID);
	        System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
	        System.out.println("Add New Employee Successfully!");
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	    } catch (Exception ex) {
	        System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	        System.out.println("Unable to add new Employee Successfully!");
	        System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
	       
	    }

	    System.out.println("");
	}
	

	
	
	
	/**
	 * To transfer the employee to another department.
	 *
	 * This method prompts the user to enter the employee ID (created by admin) and the department ID (created by admin)
	 * to which the employee needs to be transferred.
	 * 
	 * The user's input is used to call the 'transferemployeetootherdepart' method in the 'AdminDAO' implementation.
	 * 
	 * If the transfer is successful, a success message is displayed.
	 * 
	 * If an exception occurs during the process, an error message is displayed.
	 */
	@Override
	void transferemployeetootherdepartUI(Scanner sr) {
		// TODO Auto-generated method stub
		System.out.println("");
	    System.out.println("----------------------------------------------------");
	    System.out.println("Transfer employee into different deptment In Record");
	    System.out.println("----------------------------------------------------");
	   
		
		System.out.print("Enter employee Id (Created By Admin (empId)): ");
		String empId = sr.next();

		System.out.print("Enter deptID (Created By Admin (deptId)) In which Employee need to be Transfer : ");
		String deptID = sr.next();

		AdminDAO adminDAO = new AdminDAOImpl();

		try {
			adminDAO.transferemployeetootherdepart(empId, deptID);
			System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
	        System.out.println("Updated deptId into Employee record Successfully!");
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);

		} catch (Exception ex) {
			System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	        System.out.println("Unable to update deptId of employee!");
	        System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
		}

		System.out.println("");

	}

	
	
	/**
	 * To delete a department.
	 *
	 * This method prompts the user to enter the department ID (created by admin) of the department to be deleted from the record.
	 * 
	 * The user's input is used to call the 'deleteDepartment' method in the 'AdminDAO' implementation.
	 * 
	 * If the department is successfully deleted, a success message is displayed.
	 * 
	 * If an exception occurs during the process, an error message is displayed.
	 */
	@Override
	void deleteDepartmentUI(Scanner sr) {
		System.out.println("");
	    System.out.println("----------------------------------------------------");
	    System.out.println("Delete Department From The Record");
	    System.out.println("----------------------------------------------------");
		
		System.out.print("Enter deptID (Created By Admin (deptId)) To Delete from Record");
		String deptID = sr.next();

		AdminDAO adminDAO = new AdminDAOImpl();

		try {
			adminDAO.deleteDepartment(deptID);
			System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
	        System.out.println("Delete Department Successfully!");
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);

		} catch (Exception ex) {
			
			System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	        System.out.println("Unable to Delete From Record!");
	        System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
		}

		System.out.println("");

	}
	
	
	
	
	/**
	 * Displays the update leave menu.
	 *
	 * This method prints the options available for updating the leave status of an employee.
	 * 
	 * The options include accepting the leave, rejecting the leave, and going back to the previous menu.
	 * 
	 */
	private static void leavesMenu() {
	    System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT +"+---------------------------------------------+");
	    System.out.println("|             Update Leave Menu              |");
	    System.out.println("+---------------------------------------------+"+ConsoleColor.RESET);
	    System.out.println("| Press 1 : To Accept Leave of Employee       |");
	    System.out.println("| Press 2 : To Reject Leave of Employee       |");
	    System.out.println("| Press 0 : To Go Back                        |");
	    System.out.println("+---------------------------------------------+");
	}
	
	
	
	/**
	 * To Display the pending leave requests and allows the admin to accept or reject them.
	 *
	 * This method retrieves a list of pending leave requests from the admin DAO.
	 * 
	 * It then displays the details of each pending leave request, including leave ID, employee ID, employee name,
	 * days of leave, leave type, reason, date, and status.
	 * 
	 * The admin is prompted to choose an action: accept a leave request, reject a leave request, or go back.
	 * 
	 * The chosen action is executed by calling the corresponding method in the admin DAO.
	 * 
	 * Upon successful acceptance or rejection of a leave request, a success message is displayed.
	 * 
	 * If there are no pending leave requests then No Record found message is displayed
	 * but if an error occurs, an appropriate message is displayed.
	 */
	@Override
	void aceeptOrRejectLeavesOfEmployeeUI(Scanner sr) {
		System.out.println("");
		AdminDAO adminDAO = new AdminDAOImpl();
		Map<Integer, LeaveDTO> map = null;
		try {
			map = adminDAO.getListOfLeaveRequst();

			System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT +"+-------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                                      List Of Panding Leave                                             |");
			System.out.println("+------------+-----------+------------------+------------------+----------+------------------+---------------+------------+"+ConsoleColor.RESET);
			System.out.println("|  Leave_Id  |  empId    |     empName      |   days_of_leave  |   type   |      reason      |     date      |   status   |");
			System.out.println("+------------+-----------+------------------+------------------+----------+------------------+---------------+------------+");
			map.forEach((i, obj) -> {
				System.out.println("|      " + i +"     "+   obj.toString());
			});
			System.out.println("");
			Thread.sleep(1000);
			int leaveId = 0;
			String choice = "0";
			do {
				System.out.println("");
				leavesMenu();
				System.out.print("Enter your choice : ");
				choice = sr.next();
				switch (choice) {
				case "1":
					do {
						System.out.print("Enter The LeaveId of which you want to Accept: ");
						leaveId = sr.nextInt();
						if (map.containsKey(leaveId)) {
							adminDAO.acceptLeaveOfEmployee(leaveId);
							System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
					        System.out.println("Accept The Leave Successfully!");
					        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
						} else {
							System.out.println(ConsoleColor.RED+"----------------------------------------------------");
					        System.out.println("Please Enter the valid leaveId!");
					        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
						}

					} while (!map.containsKey(leaveId));
					break;

				case "2":
					do {
						System.out.print("Enter The LeaveId of which you want to Reject: ");
						leaveId = sr.nextInt();
						if (map.containsKey(leaveId)) {
							adminDAO.rejectLeaveOfEmployee(leaveId);
							System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
					        System.out.println("Reject The Leave Successfully!");
					        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
						} else {
							System.out.println(ConsoleColor.RED+"----------------------------------------------------");
					        System.out.println("Please Enter the valid leaveId!");
					        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
						}

					} while (!map.containsKey(leaveId));
					break;

				case "0":
					System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
			        System.out.println("Thanks For The Visit!");
			        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
					break;

				default:
					System.out.println(ConsoleColor.RED+"----------------------------------------------------");
			        System.out.println("Opps! please Enter the valid choice!");
			        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
				}
			} while (!choice.equals("1") && !choice.equals("2") && !choice.equals("0"));

		} catch (Exception ex) {
			System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	        System.out.println("No Record Found!");
	        System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
			// System.out.println("There is no record to found.........");
		}

	}

	
	/**
	 * Allows the admin to fire an employee by providing their employee ID.
	 *
	 * This method prompts the admin to enter the employee ID of the employee they want to fire.
	 * 
	 * It then calls the corresponding method in the admin DAO to remove the employee from the system.
	 * 
	 * If firing of the employee is successful, a success message is displayed.
	 * 
	 * If an error occurs or the employee is not found, an appropriate message is displayed.
	 */
	@Override
	void fireEmployeeUI(Scanner sr) {
		System.out.println("");
	    System.out.println("----------------------------------------------------");
	    System.out.println("Fire Employee");
	    System.out.println("----------------------------------------------------");
	    
		System.out.print("Enter employee Id (Created By Admin (empId)) : ");

		String empId = sr.next();

		AdminDAO adminDAO = new AdminDAOImpl();

		try {
			adminDAO.fireEmployee(empId);
			System.out.println(ConsoleColor.GREEN+"----------------------------------------------------");
	        System.out.println("Fire Employee Successfully!");
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);

		} catch (Exception ex) {
			System.out.println(ConsoleColor.RED+"----------------------------------------------------");
	        System.out.println("Unable to Delete Department!");
	        System.out.println(ex.getMessage());
	        System.out.println("----------------------------------------------------"+ConsoleColor.RESET);
		}

		System.out.println("");

	}

}
