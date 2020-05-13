package com.dealership.menu;

import java.util.Scanner;

import com.dealership.dao.CustomerDAO;
import com.dealership.daoImpl.CustomerDAOImpl;
import com.dealership.model.Customer;
import com.dealership.service.PaymentMethods;

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
	
	public static void customerMain(Customer customer) {
		
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);

		System.out.println("What would you like to do " + customer.getFirstName() + "?");
		System.out.println(
				"1.) View Cars \n"
				+ "2.) Make an offer \n"
				+ "3.) View your cars \n"
				+ "4.) View all payments \n"
				+ "5.) Make Your Payment \n"
				+ "6.) Main Menu \n");
		int choice = integer.nextInt();
		switch (choice) {
		case 1:
			CarMenu.viewAllCars();
			System.out.println("Press any key then enter.");
			String nothing = txt.next();
			customerMain(customer);
			break;
		case 2:
			CarMenu.makeAnOffer(customer);
			customerMain(customer);
			break;
		case 3:
			CarMenu.viewMyCars(customer);
			customerMain(customer);
			break;
		case 4:
			PaymentMenu.viewMyPayments(customer.getCustomer_id());
			customerMain(customer);
			break;
		case 5:
			System.out.println("Which payment would you like to handle?");
			PaymentMenu.viewMyPayments(customer.getCustomer_id());
			System.out.println("Please enter the id of the payment.");
			int payment_id = integer.nextInt();
			System.out.println("Please enter the amount you would like to pay.");
			int amount  = integer.nextInt();
			PaymentMethods.subtractPayment(payment_id, amount);
			customerMain(customer);
			break;
		case 6:
			MainMenu.start();
			break;

		default:
			System.out.println("Not a valid input.");
			customerMain(customer);
			break;
		}
		
	};

}
