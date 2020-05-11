package com.dealership.menu;

import java.util.Scanner;

import com.dealership.daoImpl.EmployeeDAOImpl;
import com.dealership.model.Employee;

public class MainMenu {
	public static void start() {
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		System.out.println("Welcome to the main menu!");
		System.out.println("Are you an 1.) Employee 2.) Customer 3.) Register");
		int choice = integer.nextInt();
		switch (choice) {
		
		//EmployeeMenu
		case 1:
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
			choice = integer.nextInt();
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
				start();
				break;

			default:
				break;
			}
			
			break;
		case 2:
			break;
		default:
			break;
		}
	}
}
