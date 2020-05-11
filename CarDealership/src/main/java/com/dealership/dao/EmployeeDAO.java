package com.dealership.dao;

import java.sql.SQLException;

public interface EmployeeDAO {
	public void createEmployee(String firstName, String lastName, String userName, String password) throws SQLException;
}
