package com.dealership.menu;

import java.util.Scanner;

import com.dealership.menu.MainMenu;
import com.dealership.daoImpl.EmployeeDAOImpl;
import com.dealership.model.Employee;

public class EmployeeMenu {
	
	public static void createEmployee() {
		String firstName;
		String lastName;
		String userName;
		String password;
		String confirm;
		
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		System.out.println("Time to register as a employee");
		System.out.println("Please enter your first name.");
		firstName = txt.nextLine();
		System.out.println("Please enter your last name.");
		lastName = txt.nextLine();
		System.out.println("Come up with a user name.");
		userName = txt.nextLine();
		System.out.println("Now for the password.");
		password = txt.nextLine();

		edi.createEmployee(firstName, lastName, userName, password);
		System.out.println("Welcome " + firstName);
	}
	
	public static void employeeMain() {
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		
		String user;
		String pass;
		
		System.out.println("What is your username?");
		user = txt.nextLine();
		System.out.println("What is your password?");
		pass = txt.nextLine();
		Employee employee = edi.getEmployee(user, pass);
		System.out.println("What would you like to do " + employee.getFirstName() + "?");
		System.out.println(
				"1.) Add a car to the lot \n"
				+ "2.) Accept of Reject pending offers \n"
				+ "3.) Remove a car from the lot \n"
				+ "4.) View all payments \n"
				+ "5.) Main Menu \n");
		int choice = integer.nextInt();
		switch (choice) {
		case 1:
			CarMenu.addToLot();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			MainMenu.start();
			break;

		default:
			break;
		}
	}
}
