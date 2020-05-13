package com.dealership.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dealership.daoImpl.CarDAOImpl;
import com.dealership.daoImpl.OfferDAOImpl;
import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.model.Employee;

public class CarMenu {
	
	public static void addToLot(Employee employee) {
		CarDAOImpl carImpl = new CarDAOImpl();
		String make;
		String model;
		int year;
		String isOwned ="No";
		int value;
		int customer_id=0;
		
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		System.out.println("Let's make a car");
		System.out.println("Enter the name of the car");
		make = txt.nextLine();
		System.out.println("Enter the model");
		model = txt.nextLine();
		System.out.println("Enter the year");
		year = integer.nextInt();
		System.out.println("The price!");
		value = integer.nextInt();
		
		Car car = new Car(1, make, model, year, isOwned, value, customer_id);
		try {
			carImpl.createCar(car);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Would you like to add another one? Y/N");
		String answer = txt.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			addToLot(employee);
		}else if(answer.equalsIgnoreCase("n")) {
			System.out.println("Ok thanks!");
			EmployeeMenu.employeeMain(employee);
		}
	}
	
	public static void viewAllCars(){
		CarDAOImpl cardi = new CarDAOImpl();
		List<Car> cars = cardi.viewCars();
		System.out.println(cars);
	}
	
	
	public static void makeAnOffer(Customer customer) {
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		OfferDAOImpl odi = new OfferDAOImpl();
		
		System.out.println("Looking to make offer? Here is a list of the cars.");
		viewAllCars();
		System.out.println("Please enter Your offer amount.");
		int offer = integer.nextInt();
		System.out.println("Please enter the id of the car you want.");
		int car_id = integer.nextInt();
		odi.makeOffer(offer, car_id, customer.getCustomer_id());
		System.out.println("Your offer has been placed!");
	}
	
	public static void acceptOffer() {
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		OfferDAOImpl odi = new OfferDAOImpl();
		System.out.println(odi.viewOffers());
		System.out.println("Please enter the ID of the Car you would like approve or deny.");
		int car_id = integer.nextInt();
		System.out.println("Please enter the Customer ID of whom you would like to approve or deny.");
		int customer_id = integer.nextInt();
		System.out.println("Would you like to Approve or Deny this offer? ");
		String offer_status = txt.nextLine();
		odi.acceptOffer(offer_status, customer_id, car_id);
	}
	
	public static void removeACar() {
		Scanner integer = new Scanner(System.in);
		viewAllCars();
		System.out.println("Enter the car id that you would like to remove.");
		int car_id = integer.nextInt();
		CarDAOImpl cdi = new CarDAOImpl();
		cdi.removeCar(car_id);
	}
	
	public static void viewMyCars(Customer customer) {
		CarDAOImpl cardi = new CarDAOImpl();
		List<Car> cars = cardi.viewUsersCars(customer.getCustomer_id());
		System.out.println(cars);
		
	}
	
}
