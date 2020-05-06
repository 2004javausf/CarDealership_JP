package com.dealership.model;

public class Address {

	private int address_id;
	private String streetName;
	private String city;
	private String state;
	private int zip;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(int address_id, String streetName, String city, String state, int zip) {
		super();
		this.address_id = address_id;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", streetName=" + streetName + ", city=" + city + ", state="
				+ state + ", zip=" + zip + "]";
	}
	
	
}
