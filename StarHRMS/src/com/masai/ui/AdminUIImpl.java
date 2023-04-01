package com.masai.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.DepartmentDAO;
import com.masai.dao.DepartmentDAOImpl;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.dto.DepartmentDTO;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.EmployeeDTOImpl;

public class AdminUIImpl extends AdminUI {
	
	@Override
	void addNewDepartmentUI(Scanner sr) {
		System.out.println("==========================");
		System.out.println("Enter New Department Detials To Add In Record");
		System.out.print("Enter New Department ID : ");
		String deptId = sr.next();
		System.out.println("Enter New Department Name : ");
		String deptName = sr.next();
		
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		
		try {
			deptDAO.addNewDepartment(deptId,deptName);
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
		
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		
		try {
			List<DepartmentDTO> list = deptDAO.viewAllDepartment();
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
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		try {
			List<EmployeeDTO> list = empDAO.viewAllEmployee();
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
		System.out.println("_______________________________________________");
		
	}
	
	
	@Override
	void updateDepartmentUI(Scanner sr) {
		System.out.println("==========================");
		System.out.println("___________________________");
		int choice = 0;
		do {
			AdminUIImpl.updateMenu();
			System.out.print("Enter your selection: ");
			choice = sr.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Sorry this service is termery close please choose option 3");
					break;
				case 2:
					System.out.println("Sorry this service is termery close please choose option 3");
					break;
				case 3:
					updateDepartmentAllDetailsUI(sr);
					break;
				case 0:
					System.out.println("Thank you -----");
			}
			
		}while(choice!=0);
		
		System.out.println("==========================");
		
	}
	
	void updateDepartmentAllDetailsUI(Scanner sr) {
		System.out.println("==========================");
		System.out.print("Enter Department Id ( In which Updation need to be done ) : ");
		String oldDeptID = sr.next();
		System.out.println("Enter Updated Departmnet Details........");
		System.out.print("Enter Updated Department ID : ");
		String deptId = sr.next();
		System.out.println("Enter Updated Department Name : ");
		String deptName = sr.next();
		
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		
		try {
			deptDAO.updateDepartmentAllDetails(oldDeptID,deptId,deptName);
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
		
		System.out.println("Enter Employee Name ");
		employee.setEname(sr.next());
	
		System.out.println("Enter Employee Email : ");
		employee.setEmail(sr.next());
		
		System.out.println("Enter Employee Address : ");
		employee.setEmpAddress(sr.next());

		System.out.println("Enter Employee Joing_Date (yyyy-mm-xx) : ");
		employee.setDate(LocalDate.parse(sr.next())); 
		
		
		System.out.println("Enter Employee Salary_Per_Month : ");
		employee.setSalary(sr.nextDouble());
		
		System.out.println("Want to Enter password ( Y / N ) : ");
		if(sr.next().toUpperCase()== "Y") {
			employee.setPassword(sr.next());
		}
		System.out.println("Want to Enter deptment ID ( Y / N ) : ");
		if(sr.next().toUpperCase()== "Y") {
		
			employee.setDept(Integer.parseInt(sr.next()));
		}	
		
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		
		try {
			deptDAO.addNewDepartment(deptId,deptName);
			System.out.println("Add New Department Successfully-----");
		}catch(Exception ex) {
			System.out.println(ex);
			System.out.println("Unable to add new Department Successfully");
		}
		
		System.out.println("==========================");
	}
	@Override
	void transferemployeetootherdepartUI(Scanner sr) {
		// TODO Auto-generated method stub
		
	}
	@Override
	void aceeptLeavesOfEmployeeUI(Scanner sr) {
		// TODO Auto-generated method stub
		
	}
	@Override
	void rejectLeavesOfEmployeeUI(Scanner sr) {
	
		
	}
	@Override
	void deleteDepartmentUI(Scanner sr) {
		
	}


}
