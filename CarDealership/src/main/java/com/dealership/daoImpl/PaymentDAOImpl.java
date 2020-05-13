package com.dealership.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dealership.dao.PaymentDAO;
import com.dealership.model.Payment;
import com.dealership.util.ConnConfig;

public class PaymentDAOImpl implements PaymentDAO {
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	
/*----------------------------------
------------VIEW ALL PAYMENTS-------
------------------------------------*/
	
	@Override
	public List<Payment> viewCustomersPayments(int customer_id) {
		List<Payment> payments = new ArrayList<Payment>();
		try {
		connection = cc.getConnection();
		String sql ="SELECT * FROM PAYMENTS WHERE CUSTOMER_ID = ?";
		stmt = connection.prepareStatement(sql);
		stmt.setInt(1, customer_id);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Payment payment = new Payment();
			payment.setPayment_id(rs.getInt("payment_id"));
			payment.setOriginal_amount(rs.getInt("original_amount"));
			payment.setCustomer_id(rs.getInt("customer_id"));
			payment.setCar_id(rs.getInt("car_id"));
			
			payments.add(payment);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return payments;
	}
/*----------------------------------
-------VIEW CUSTOMERS PAYMENTS------
------------------------------------*/
	
	@Override
	public List<Payment> viewAllPayments() {
		List<Payment> payments = new ArrayList<Payment>();
		try {
		
		
		connection = cc.getConnection();
		String sql ="SELECT * FROM PAYMENTS";
		stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Payment payment = new Payment();
			payment.setPayment_id(rs.getInt("payment_id"));
			payment.setOriginal_amount(rs.getInt("original_amount"));
			payment.setCustomer_id(rs.getInt("customer_id"));
			payment.setCar_id(rs.getInt("car_id"));
			
			payments.add(payment);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return payments;
	}	
	
/*----------------------------------
----------GET ONE PAYMENT-----------
------------------------------------*/
	public Payment getPayment(int payment_id) {
		Payment payment = new Payment();
		try {
			connection = cc.getConnection();
			String sql = "SELECT * FROM PAYMENTS WHERE PAYMENT_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1,  payment_id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				payment.setPayment_id(rs.getInt("payment_id"));
				payment.setOriginal_amount(rs.getInt("original_amount"));
				payment.setCustomer_id(rs.getInt("customer_id"));
				payment.setCar_id(rs.getInt("car_id"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return payment;
	}
/*----------------------------------
----------UPDATE PAYMENT-----------
------------------------------------*/
	public void updatePayment(Payment payment) {
		try {
			connection = cc.getConnection();
			String sql = "UPDATE PAYMENTS SET ORIGINAL_AMOUNT = ? WHERE PAYMENT_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1,  payment.getOriginal_amount());
			stmt.setInt(2, payment.getPayment_id());
			
			stmt.executeUpdate();
			
			}catch(SQLException e) {
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
