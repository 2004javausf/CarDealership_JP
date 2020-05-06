package com.dealership.model;

public class Customer {
	private int customer_id;
	private String firstName;
	private String lastName;
	private int address_id;
	private int user_id;
	private int car_id;
	
	public Customer(int customer_id, String firstName, String lastName, int address_id, int user_id, int car_id) {
		super();
		this.customer_id = customer_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address_id = address_id;
		this.user_id = user_id;
		this.car_id = car_id;
	}
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address_id=" + address_id + ", user_id=" + user_id + ", car_id=" + car_id + "]";
	}
	
	
	
	
}
