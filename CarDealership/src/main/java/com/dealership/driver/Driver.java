package com.dealership.driver;

import java.sql.SQLException;
import java.util.List;

import com.dealership.daoImpl.CarDAOImpl;
import com.dealership.model.Car;

public class Driver {
	public static void main(String[] args) {
		CarDAOImpl carImpl = new CarDAOImpl();
		try {
			List<Car> cars =carImpl.viewCars();
			System.out.println(cars);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
