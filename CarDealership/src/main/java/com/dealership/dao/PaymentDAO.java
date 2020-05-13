package com.dealership.dao;

import java.util.List;

import com.dealership.model.Payment;

public interface PaymentDAO {
	
	public List<Payment> viewAllPayments();
	public List<Payment> viewCustomersPayments(int cusotmer_id);

}
