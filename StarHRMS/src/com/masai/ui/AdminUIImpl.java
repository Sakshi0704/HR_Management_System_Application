package com.masai.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.masai.dao.AdminDAO;
import com.masai.dao.AdminDAOImpl;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.dao.LeaveDAO;
import com.masai.dto.DepartmentDTO;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.EmployeeDTOImpl;
import com.masai.dto.LeaveDTO;

public class AdminUIImpl extends AdminUI {
	
	@Override
	void addNewDepartmentUI(Scanner sr) {
		System.out.println("==========================");
		System.out.println("Enter New Department Detials To Add In Record");
		System.out.print("Enter New Department ID : ");
		String deptId = sr.next();
		System.out.print("Enter New Department Name : ");
		String deptName = sr.next();
		
		AdminDAO adminDAO = new AdminDAOImpl();
		
		try {
			adminDAO.addNewDepartment(deptId,deptName);
			System.out.println("Add New Department Successfully-----");
		}catch(Exception ex) {
			System.out.println(ex);
			System.out.println("Unable to add new Department Successfully");
		}
		
		System.out.println("==========================");
		
	}
	@Override
	void viewAllDepartmentUI() {
		System.out.println("==========================");
		
		AdminDAO adminDAO = new AdminDAOImpl();
		
		try {
			List<DepartmentDTO> list = adminDAO.viewAllDepartment();
			System.out.println("All Department Details.........");
			list.stream().forEach(System.out::println);
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		System.out.println("==========================");
		
	}
	@Override
	void viewAllEmployeeUI(Scanner sr) {
		System.out.println("==========================");
		
		AdminDAO adminDAO = new AdminDAOImpl();
		
		try {
			List<EmployeeDTO> list = adminDAO.viewAllEmployee();
			System.out.println("All Employee Details.........");
			list.stream().forEach(System.out::println);
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		System.out.println("==========================");
		
	}
	
	private static void updateMenu() {
		System.out.println("==============================================");
		System.out.println("Want to update.................");
		System.out.println(" Press 1 --> To Update Department ID ");
		System.out.println(" Press 2 --> To Update Department Name");
		System.out.println(" Press 3 --> To Update Department All Details ");
		System.out.println(" Press 0 --> Exit / Go Back  ");
		System.out.println("_______________________________________________");
	}
	
	
	@Override
	void updateDepartmentUI(Scanner sr) {
		System.out.println("==========================");
		System.out.println("___________________________");
		String choice = "0";
		do {
			AdminUIImpl.updateMenu();
			System.out.print("Enter your selection: ");
			choice = sr.next();
			switch(choice) {
				case "1":
					System.out.println("Sorry this service is termery close please choose option 3");
					break;
				case "2":
					System.out.println("Sorry this service is termery close please choose option 3");
					break;
				case "3":
					updateDepartmentAllDetailsUI(sr);
					break;
				case "0":
					System.out.println("Thank you -----");
					break;
					
				default:
					System.out.println("Opps !! Please Enter Correct Option");
			}
			
		}while(!choice.equals("0"));
		
		System.out.println("==========================");
		
	}
	
	void updateDepartmentAllDetailsUI(Scanner sr) {
		System.out.println("==========================");
		System.out.print("Enter Department Id ( System - Generated (did)) : ");
		int oldDeptID = sr.nextInt();
		System.out.println("Enter Updated Department Details........");
		System.out.print("Enter Updated Department ID ( Created By Admin (deptId)) : ");
		String deptId = sr.next();
		System.out.print("Enter Updated Department Name : ");
		String deptName = sr.next();
		
		AdminDAO adminDAO = new AdminDAOImpl();
		
		try {
			adminDAO.updateDepartmentAllDetails(oldDeptID,deptId,deptName);
			System.out.println("Updated Department Successfully-----");
		}catch(Exception ex) {
			System.out.println(ex);
			System.out.println("Unable to Update Department Successfully");
		}
		
		System.out.println("==========================");
	}
	
	@Override
	void addNewEmployeeUI(Scanner sr) {
		System.out.println("===========================================");
		System.out.println("Enter New Employee Detials To Add In Record");
		
		EmployeeDTO employee = new EmployeeDTOImpl();
		System.out.print("Enter Employee ID : ");
		employee.setEmpId(sr.next());
		
		System.out.print("Enter Employee Name ");
		employee.setEname(sr.next());
	
		System.out.print("Enter Employee Email : ");
		employee.setEmail(sr.next());
		
		System.out.print("Enter Employee Address : ");
		employee.setEmpAddress(sr.next());

		System.out.print("Enter Employee Joing_Date (yyyy-mm-xx) : ");
		employee.setDate(LocalDate.parse(sr.next())); 
		
		
		System.out.print("Enter Employee Salary_Per_Month : ");
		employee.setSalary(sr.nextDouble());
		
		int did = 1;
		System.out.print("Wants to add deptId ( Y / N ) : ");
		if(sr.next().toUpperCase().equals("Y")) {
			System.out.print("Enter deptId ( System - Generated (did)):  ");
			did = sr.nextInt();
		}
		
		AdminDAO adminDAO = new AdminDAOImpl();
		
		try {
			adminDAO.addNewEmployee(employee,did);
			System.out.println("Add New Employee Successfully-----");
		}catch(Exception ex) {
			System.out.println(ex);
			System.out.println("Unable to add new Employee Successfully");
		}
		
		System.out.println("==========================");
	}
	@Override
	void transferemployeetootherdepartUI(Scanner sr) {
		// TODO Auto-generated method stub
		System.out.println("===========================================");
		System.out.println("Enter employee Id : ");
		int eId = sr.nextInt();
		
		System.out.println("Enter deptID In which Employee need to be Transfer : ");
		int did = sr.nextInt();
		
		AdminDAO adminDAO = new AdminDAOImpl();
		
		try {
			adminDAO.transferemployeetootherdepart(eId,did);
			System.out.println("Updated deptId into Employee record Successfully.........");
			
		}catch(Exception ex) {
			System.out.println(ex);
			System.out.println("Unable to updated deptId of employee ! please try again leter.........");
		}
		
		System.out.println("==========================");
		
		
	}

	@Override
	void deleteDepartmentUI(Scanner sr) {
		System.out.println("===========================================");
		System.out.println("Enter deptID To Delete from Record");
		String deptID = sr.next();
		
		AdminDAO adminDAO = new AdminDAOImpl();
		
		try {
			adminDAO.deleteDepartment(deptID);
			System.out.println("Delete Department Successfully.........");
			
		}catch(Exception ex) {
			System.out.println(ex);
			System.out.println("Unable to Delete Department.........");
		}
		
		System.out.println("==========================");
		
	}
	
	
	private static void leavesMenu() {
		System.out.println("==============================================");
		System.out.println("Want to update.................");
		System.out.println(" Press 1 --> To Accept Leave of Employee ");
		System.out.println(" Press 2 --> To Reject Leave of Employee ");
		System.out.println("_______________________________________________");
		
	}
	
	@Override
	void aceeptOrRejectLeavesOfEmployeeUI(Scanner sr) {
		System.out.println("========================================="); 
		AdminDAO adminDAO = new AdminDAOImpl();
		Map<Integer,LeaveDTO> map = null;
		try {
			map = adminDAO.getListOfLeaveRequst();
			map.forEach((i,obj) -> {
				System.out.println(i + " " + obj.toString());
			});
			System.out.println("________________________________________");
			int leaveId = 0;
			int choice = 0;
			do {
				leavesMenu();
				System.out.println("Enter your choice : ");
				choice = sr.nextInt();
				switch(choice) {
					case 1:
						do {
							System.out.println("Enter The LeaveId of which you want to Accept: ");
							leaveId = sr.nextInt();
							if(map.containsKey(leaveId)) {
								adminDAO.acceptLeaveOfEmployee(leaveId);
								System.out.println("Accept The Leave Successfully !!");
							}
							else {
								System.out.println("Please Enter the valid leaveId");
							}
									
						}while(!map.containsKey(leaveId));
						
					case 2:
						do {
							System.out.println("Enter The LeaveId of which you want to Reject: ");
							leaveId = sr.nextInt();
							if(map.containsKey(leaveId)) {
								adminDAO.rejectLeaveOfEmployee(leaveId);
								System.out.println("Reject The Leave Successfully !!");
							}
							else {
								System.out.println("Please Enter the valid leaveId");
							}
									
						}while(!map.containsKey(leaveId));
					
					default:
						System.out.println("Opps! please Enter the valid choice");
								
				}
			}while(choice != 1 && choice != 2);
			
		}catch(Exception ex) {
			System.out.println(ex);
			System.out.println("There is no record to found.........");
		}
		

	}
	@Override
	void fireEmployeeUI(Scanner sr) {
		System.out.println("===========================================");
		System.out.println("Enter employee Id ( on record ) = ");
		int eId = sr.nextInt();
		
		AdminDAO adminDAO = new AdminDAOImpl();
		
		try {
			adminDAO.fireEmployee(eId);
			System.out.println("Delete Department Successfully.........");
			
		}catch(Exception ex) {
			System.out.println(ex);
			System.out.println("Unable to Delete Department.........");
		}
		
		System.out.println("==========================");
		
	}

}
