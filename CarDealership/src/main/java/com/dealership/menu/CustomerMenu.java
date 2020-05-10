package com.dealership.menu;

import java.util.Scanner;

import com.dealership.daoImpl.CustomerDAOImpl;

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

}
