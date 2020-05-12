package com.dealership.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dealership.dao.OfferDAO;
import com.dealership.util.ConnConfig;

public class OfferDAOImpl implements OfferDAO {
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	
	public void makeOffer(int offer, int car_id, int customer_id) {
		try {
		connection = cc.getConnection();
		String sql = "INSERT INTO OFFERS VALUES(null,?,?,?,?)";
		stmt = connection.prepareStatement(sql);
		stmt.setInt(1, offer);
		stmt.setInt(2, car_id);
		stmt.setInt(3, customer_id);
		stmt.setString(4, "PENDING");
		stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
	}

/*----------------------------------
------------Accept Offers----------
------------------------------------*/
	
	public void acceptOffer(String offer_status, int customer_id) {
		try {
		connection = cc.getConnection();
		String sql = "{ call ACCEPT_OFFER_PRO( ?,?)";
		CallableStatement call = connection.prepareCall(sql);
		call.setString(1, offer_status);
		call.setInt(2, customer_id);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
	}
	
/*----------------------------------
------------View Offers-------------
------------------------------------*/
	
	
	
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
