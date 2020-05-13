package com.dealership.model;

public class Car {
	
	private int car_id;
	private String make;
	private String model;
	private int year;
	private String isOwned;
	private int value;
	private int customer_id;
	


	public Car(int car_id, String make, String model, int year, String isOwned, int value, int customer_id) {
		super();
		this.car_id = car_id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.isOwned = isOwned;
		this.value = value;
		this.customer_id = customer_id;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsOwned() {
		return isOwned;
	}
	
	public void setIsOwned(String isOwned) {
		this.isOwned = isOwned;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", make=" + make + ", model=" + model + ", year=" + year + ", value=" + value + ", owned=" + isOwned + "] \n";
	}
	
	
	
	
}
