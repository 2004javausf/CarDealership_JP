package com.dealership.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.dealership.daoImpl.CarDAOImpl;
import com.dealership.model.Car;

public class CarMenu {
	
	public static void addToLot() {
		CarDAOImpl carImpl = new CarDAOImpl();
		String make;
		String model;
		int year;
		String isOwned ="No";
		int value;
		
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
		
		Car car = new Car(1, make, model, year, isOwned, value);
		try {
			carImpl.createCar(car);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
