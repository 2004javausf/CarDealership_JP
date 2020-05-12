package com.dealership.dao;

import com.dealership.model.Customer;

public interface CustomerDAO {
	public void createCustomer(String firstName, String lastName, String userName, String dealer_password,
			String streetName, String city, int zip);
	public Customer getCustomer(String userName, String password);
}
