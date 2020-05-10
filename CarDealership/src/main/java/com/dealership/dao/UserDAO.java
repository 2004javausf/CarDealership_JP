package com.dealership.dao;

import java.sql.SQLException;

public interface UserDAO {
	
	//CREATE METHODS
	public void createUser(String user_name, String dealer_password, String emp_status) throws SQLException;
}
