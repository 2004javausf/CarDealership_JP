package com.dealership.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dealership.dao.CarDAO;
import com.dealership.model.Car;
import com.dealership.util.ConnConfig;
import com.dealership.util.DealershipLog;

public class CarDAOImpl implements CarDAO {
	
	
	public static ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	
/*----------------------------------
------------CREATE A CAR---------
------------------------------------*/
	
	@Override
	public void createCar(Car car) throws SQLException {
		try {
			connection = cc.getConnection();
			String sql = "INSERT INTO CARS VALUES(?,?,?,?,?,?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, car.getCar_id());
			stmt.setString(2, car.getMake());
			stmt.setString(3, car.getModel());
			stmt.setInt(4, car.getYear());
			stmt.setString(5, car.getIsOwned());
			stmt.setInt(6, car.getValue());
			
			stmt.executeUpdate();
			
			DealershipLog.LogIt("info", "Car has been added to the lot.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
	}
	
/*----------------------------------
------------VIEW CARS---------------
------------------------------------*/

	@Override
	public List<Car> viewCars() throws SQLException {
		List<Car> carList = new ArrayList<Car>();
		try {
			connection = cc.getConnection();
			String sql = "SELECT * FROM CARS";
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			//When getting the result set you must grab the
					//COLUMN NAMES
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setMake(rs.getString("make"));
				car.setModel(rs.getString("car_model"));
				car.setYear(rs.getInt("car_year"));
				car.setIsOwned(rs.getString("is_Owned"));
				car.setValue(rs.getInt("car_value"));
				
				carList.add(car);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return carList;
	}
	
	
	
/*-----------------------------------------------------------------------------*/	
	
	
/*----------------------------------
------------CLOSE RESOURCES----------
------------------------------------*/

	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}



}
