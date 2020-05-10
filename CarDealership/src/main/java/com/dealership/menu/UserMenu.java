package com.dealership.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.dealership.daoImpl.UserDAOImpl;

public class UserMenu {
	
	public static void createUser() {
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		UserDAOImpl userDaoImpl = new UserDAOImpl();
		
		
		String user_name;
		String password;
		String emp_status = "n";
		
		System.out.println("Lets get you a user account!");
		System.out.println("Select a user name.");
		user_name = txt.nextLine();
		System.out.println("Make a password.");
		password = txt.nextLine();
		System.out.println("Are you an employee? Y/N");
		emp_status = txt.nextLine();
		if(!emp_status.equalsIgnoreCase("n") || !emp_status.equalsIgnoreCase("y")) {
//			while(!(emp_status.equalsIgnoreCase("n")) || !(emp_status.equalsIgnoreCase("y"))) {
//				System.out.println("Please insert a  appropriate choice.");
//				emp_status = txt.nextLine();
//			}
			System.out.println("Made it to the if block");
			System.out.println(user_name);
		}
		
		try {
			userDaoImpl.createUser(user_name, password, emp_status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
