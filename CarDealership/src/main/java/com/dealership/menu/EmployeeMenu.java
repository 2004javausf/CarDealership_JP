package com.dealership.menu;

import java.util.Scanner;

import com.dealership.daoImpl.EmployeeDAOImpl;

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
}
