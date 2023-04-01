package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.dto.EmployeeDTO;
import com.masai.exception.NoSuchRecordFoundException;
import com.masai.exception.SomthingWentWrongException;

public class EmployeeUIImpl extends EmployeeUI{

	static void updateMenu() {
		System.out.println("Select your choice want you want to update ............");
		System.out.println("Press 1: Address");
		System.out.println("Press 2: emailId");
		System.out.println("Press 3: Password");
	}
	@Override
	public void viewYourProfileUI() {
		//String empName = EmployeeUI.getEmpName();
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
			try {
				List<EmployeeDTO> employee = empDAO.viewYourProfile(EmployeeUI.getEmpId());
				employee.stream().forEach(System.out::println);
				
			} catch (NoSuchRecordFoundException | SomthingWentWrongException e) {
				System.out.println(e);
			}
	}

	@Override
	public void updateProfileUI(Scanner sr) {
		System.out.println("................................");
		EmployeeUIImpl.updateMenu();
		int choice = 0;
		do {
			
			System.out.print("Enter your selection: ");
			choice = sr.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Sorry this service is termery close please connect with admin deptment");
					break;
				case 2:
					System.out.println("Sorry this service is termery close please connect with admin deptment");
					break;
				case 3:
					changePasswordUI(sr);
					break;
				case 0:
					System.out.println("Thank you -----");
			}
			
		}while(choice!=0);
		
	}

	@Override
	public void changePasswordUI(Scanner sr) {
		System.out.println("============================================");
		System.out.println("Change Your Password");
		System.out.print("Please Enter Your old Password : ");
		String oldPassword = sr.next();
		System.out.println("Please Enter Updated Password : ");
		String updatedPassword = sr.next();
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			empDAO.changePassword(oldPassword,updatedPassword,EmployeeUI.getEmpId());
			System.out.println("Update Successfull");
			
		}catch(NoSuchRecordFoundException | SomthingWentWrongException ex){
			System.out.println(ex);
		}
		System.out.println("============================================");
		
	}

	@Override
	public void applyforLeaveUI(Scanner sr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recordOfLeaveUI(Scanner sr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void totalSalaryAnnualyUI(Scanner sr) {
		// TODO Auto-generated method stub
		
	}

}
