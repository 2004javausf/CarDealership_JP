package com.dealership.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dealership.dao.CustomerDAO;
import com.dealership.menu.MainMenu;
import com.dealership.model.Customer;
import com.dealership.util.ConnConfig;
import com.dealership.util.DealershipLog;

public class CustomerDAOImpl implements CustomerDAO {
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	

	@Override
	public void createCustomer(String firstName, String lastName, String userName, String dealer_password,
			String streetName, String city, int zip) {
		try {
		connection = cc.getConnection();
		String sql = "{call  CUSTPRO(?,?,?,?,?,?,?)";
		CallableStatement call = connection.prepareCall(sql);
	
		call.setString(1, firstName);
		call.setString(2, lastName);
		call.setString(3, userName);
		call.setString(4, dealer_password);
		call.setString(5, streetName);
		call.setString(6, city);
		call.setInt(7, zip);
		call.execute();
		
		DealershipLog.LogIt("info", "Customer has been created and stored in the database.");
		
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
	}
/*-----------------------------------
------------GET SINGLE USER----------
------------------------------------*/
		
		public Customer getCustomer(String userName, String password) {
			Customer customer = new Customer();
			
			try {
				connection = cc.getConnection();
				String sql = "SELECT * FROM CUSTOMERS WHERE USER_ID IN"
						+ "(SELECT USER_ID FROM DEALER_USERS WHERE USER_NAME = ? AND DEALER_PASSWORD = ? )";
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, userName);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					
					customer.setCustomer_id(rs.getInt("customer_id"));
					customer.setFirstName(rs.getString("first_name"));
					customer.setLastName(rs.getString("last_name"));
					customer.setAddress_id(rs.getInt("address_id"));
					customer.setUser_id(rs.getInt("user_id"));
					customer.setCar_id(rs.getInt("car_id"));
					customer.setOffer_id(rs.getInt("offer_id"));
				}
				
				if(customer.getCustomer_id() == 0) {
					throw new SQLException("Username or password does not exist.");
				}
				
				DealershipLog.LogIt("info", "Customer has been retrieved fromt the database.");
				
				} catch(SQLException e) {
					System.out.println(e.getMessage());
					MainMenu.start();
					
				}finally {
					closeResources();
				}
			return customer;
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
