package com.dealership.model;

public class Payment {
	private int payment_id;
	private int original_amount;
	private int monthly;
	private int customer_id;
	private int car_id;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int payment_id, int original_amount, int monthly, int customer_id, int car_id) {
		super();
		this.payment_id = payment_id;
		this.original_amount = original_amount;
		this.monthly = monthly;
		this.customer_id = customer_id;
		this.car_id = car_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getOriginal_amount() {
		return original_amount;
	}

	public void setOriginal_amount(int original_amount) {
		this.original_amount = original_amount;
	}

	public int getMonthly() {
		return monthly;
	}

	public void setMonthly(int monthly) {
		this.monthly = monthly;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	@Override
	public String toString() {
		return "\n Payment [payment_id=" + payment_id + ", amount=" + original_amount + ", customer_id=" + customer_id + ", car_id=" + car_id + "] \n";
	}
	
	
}
