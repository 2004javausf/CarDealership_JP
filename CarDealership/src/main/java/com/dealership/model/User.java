package com.dealership.model;

public class User {
	
	private int user_id;
	private String userName;
	private String password;
	private boolean emp_status;
	
	public User(int user_id, String userName, String password, boolean emp_status) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.password = password;
		this.emp_status = emp_status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmp_status() {
		return emp_status;
	}

	public void setEmp_status(boolean emp_status) {
		this.emp_status = emp_status;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", userName=" + userName + ", password=" + password + ", emp_status="
				+ emp_status + "]";
	}
	
	
	

}
