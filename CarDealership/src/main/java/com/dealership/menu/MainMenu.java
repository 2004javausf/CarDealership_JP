package com.dealership.menu;

import java.util.Scanner;

import com.dealership.dao.CustomerDAO;
import com.dealership.daoImpl.CustomerDAOImpl;
import com.dealership.daoImpl.EmployeeDAOImpl;
import com.dealership.model.Customer;
import com.dealership.model.Employee;

public class MainMenu {
	public static void start() {
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		System.out.println("Welcome to the main menu!");
		System.out.println("Are you an 1.)Employee 2.)Customer 3.)Register");
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
			EmployeeMenu.employeeMain(employee);
			break;
		case 2:
			CustomerDAO cdi = new CustomerDAOImpl();
			String username;
			String password;
			
			System.out.println("What is your username?");
			username = txt.nextLine();
			System.out.println("What is your password?");
			password = txt.nextLine();
			Customer customer = cdi.getCustomer(username, password);
			CustomerMenu.customerMain(customer);
			break;
		case 3:
			System.out.println("Are you registering as 1.)Customer   OR   2.)Employee");
			choice = integer.nextInt();
			switch (choice) {
			case 1:
				CustomerMenu.createCustomer();
				start();
				break;
			case 2:
				EmployeeMenu.createEmployee();
				start();
				break;
			default:
				System.out.println("Not a valid option. Back to the main menu.");
				start();
				break;
			}
		default:
			break;
		}
	}
}
