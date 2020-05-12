package com.dealership.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dealership.dao.EmployeeDAO;
import com.dealership.menu.MainMenu;
import com.dealership.model.Employee;
import com.dealership.util.ConnConfig;
import com.dealership.util.DealershipLog;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	
	public void createEmployee(String firstName, String lastName, String userName, String password) {
		try {
			connection = cc.getConnection();
			String sql = "{call  EMPPRO(?,?,?,?)";
			CallableStatement call = connection.prepareCall(sql);
		
			call.setString(1, firstName);
			call.setString(2, lastName);
			call.setString(3, userName);
			call.setString(4, password);
			call.execute();
			
			DealershipLog.LogIt("info", "Employee has been created and stored in the database.");
			
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeResources();
			}
	}
/*-----------------------------------
------------GET SINGLE USER----------
------------------------------------*/
	
	public Employee getEmployee(String userName, String password) {
		Employee employee = new Employee();
		try {
			connection = cc.getConnection();
			String sql = "SELECT * FROM EMPLOYEES WHERE USER_ID IN"
					+ "(SELECT USER_ID FROM DEALER_USERS WHERE USER_NAME = ? AND DEALER_PASSWORD = ? )";
			stmt   = connection.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				employee.setEmployee_id(rs.getInt("employee_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setUser_id(rs.getInt("user_id"));
			}
			if(employee.getEmployee_id() == 0) {
				throw new SQLException("Username and password does not exist.");
			}
			
			DealershipLog.LogIt("info", "Employee has been retrieved fromt the database.");
			
			} catch(SQLException e) {
				System.out.println(e.getMessage());
				MainMenu.start();
			}finally {
				closeResources();
			}
		return employee;
	}
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
