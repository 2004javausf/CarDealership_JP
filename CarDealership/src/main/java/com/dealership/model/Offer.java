package com.dealership.model;

public class Offer {
	private int offer_id;
	private int offer;
	private int car_id;
	private int customer_id;
	
	
	public Offer(int offer_id, int offer, int car_id, int customer_id) {
		super();
		this.offer_id = offer_id;
		this.offer = offer;
		this.car_id = car_id;
		this.customer_id = customer_id;
	}


	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getOffer_id() {
		return offer_id;
	}


	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}


	public int getOffer() {
		return offer;
	}


	public void setOffer(int offer) {
		this.offer = offer;
	}


	public int getCar_id() {
		return car_id;
	}


	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	@Override
	public String toString() {
		return "Offer [offer_id=" + offer_id + ", offer=" + offer + ", car_id=" + car_id + ", customer_id="
				+ customer_id + "]";
	}
	
	
}
