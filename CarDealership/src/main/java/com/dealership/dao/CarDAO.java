package com.dealership.dao;

import java.sql.SQLException;
import java.util.List;

import com.dealership.model.Car;

public interface CarDAO {
	public void createCar(Car car) throws SQLException;
	public List<Car>viewCars();
	public List<Car>viewUsersCars(int customer_id);

}
