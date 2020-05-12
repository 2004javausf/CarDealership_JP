package com.dealership.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dealership.dao.OfferDAO;
import com.dealership.model.Offer;
import com.dealership.util.ConnConfig;
import com.dealership.util.DealershipLog;

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
	
	public void acceptOffer(String offer_status, int customer_id, int car_id) {
		try {
		connection = cc.getConnection();
		String sql = "{ call ACCEPT_OFFER_PRO(?,?,?)";
		CallableStatement call = connection.prepareCall(sql);
		call.setString(1, offer_status.toUpperCase());
		call.setInt(2, customer_id);
		call.setInt(3, car_id);
		
		call.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		DealershipLog.LogIt("info", "Offer has been accepted.");
	}
	
/*----------------------------------
------------View Offers-------------
------------------------------------*/
	
	public List<Offer> viewOffers() {
		List<Offer> offers = new ArrayList<Offer>();
		try {
		connection = cc.getConnection();
		String sql = "SELECT * FROM OFFERS";
		stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Offer offer = new Offer();
			offer.setOffer_id(rs.getInt("offer_id"));
			offer.setOffer(rs.getInt("offer"));
			offer.setCar_id(rs.getInt("car_id"));
			offer.setCustomer_id(rs.getInt("customer_id"));
			offer.setOffer_status(rs.getString("offer_status"));
			
			offers.add(offer);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return offers;
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
