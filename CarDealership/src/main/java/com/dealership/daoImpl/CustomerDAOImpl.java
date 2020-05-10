package com.dealership.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.dealership.dao.CustomerDAO;
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
