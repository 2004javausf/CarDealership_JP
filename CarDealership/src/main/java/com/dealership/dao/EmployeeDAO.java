package com.dealership.dao;

import java.sql.SQLException;

import com.dealership.model.Employee;

public interface EmployeeDAO {
	public void createEmployee(String firstName, String lastName, String userName, String password) throws SQLException;
	public Employee getEmployee(String userName, String password);
}
