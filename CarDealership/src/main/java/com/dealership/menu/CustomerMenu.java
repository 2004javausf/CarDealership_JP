package com.dealership.menu;

import java.util.Scanner;

import com.dealership.dao.CustomerDAO;
import com.dealership.daoImpl.CustomerDAOImpl;
import com.dealership.model.Customer;

public class CustomerMenu {
	
	public static void createCustomer() {
		String firstName;
		String lastName;
		String userName;
		String password;
		String streetName;
		String city;
		String confirm;
		int zip;
		
		CustomerDAOImpl customerImpl = new CustomerDAOImpl();
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		System.out.println("Time to register as a customer");
		System.out.println("Please enter your first name.");
		firstName = txt.nextLine();
		System.out.println("Please enter your last name.");
		lastName = txt.nextLine();
		System.out.println("Come up with a user name.");
		userName = txt.nextLine();
		System.out.println("Now for the password.");
		password = txt.nextLine();
		System.out.println("What is your street address?");
		streetName = txt.nextLine();
		System.out.println("What city do you reside in?");
		city = txt.nextLine();
		System.out.println("And the zip?");
		zip = integer.nextInt();
		customerImpl.createCustomer(firstName, lastName, userName, password, streetName, city, zip);
		System.out.println("Welcome " + firstName);
	}
	
	public static void customerMain() {
		CustomerDAO cdi = new CustomerDAOImpl();
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		String user;
		String pass;
		
		System.out.println("What is your username?");
		user = txt.nextLine();
		System.out.println("What is your password?");
		pass = txt.nextLine();
		Customer customer = cdi.getCustomer(user, pass);
		System.out.println("What would you like to do " + customer.getFirstName() + "?");
		System.out.println(
				"1.) View Cars \n"
				+ "2.) Make an offer \n"
				+ "3.) View your cars \n"
				+ "4.) View all payments \n"
				+ "5.) Main Menu \n");
		int choice = integer.nextInt();
		switch (choice) {
		case 1:
			CarMenu.viewAllCars();
			System.out.println("Press any key then enter.");
			String nothing = txt.next();
			customerMain();
			break;
		case 2:
			CarMenu.makeAnOffer(customer);
			customerMain();
			break;
		case 3:
			CarMenu.viewMyCars(customer);
			break;
		case 4:
			
			break;
		case 5:
			MainMenu.start();
			break;

		default:
			break;
		}
		
	};

}
