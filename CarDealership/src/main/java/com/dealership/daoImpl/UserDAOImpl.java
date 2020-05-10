package com.dealership.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dealership.dao.UserDAO;
import com.dealership.util.ConnConfig;
import com.dealership.util.DealershipLog;

public class UserDAOImpl implements UserDAO {
	public static ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;

	@Override
	public void createUser(String user_name, String dealer_password, String emp_status) throws SQLException {
		try {
			connection = cc.getConnection();
			String sql = "INSERT INTO DEALER_USERS VALUES(USER_SEQUENCE.NEXTVAL,?,?,?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user_name);
			stmt.setString(2, dealer_password);
			stmt.setString(3, emp_status);
			stmt.executeUpdate();
			DealershipLog.LogIt("info", "User has been added to DB");
			
		} catch (SQLException e) {
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
