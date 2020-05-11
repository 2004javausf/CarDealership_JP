package com.dealership.menu;

import java.util.Scanner;

import com.dealership.daoImpl.EmployeeDAOImpl;
import com.dealership.model.Employee;

public class LogIn {
	
	public static void logIn() {
		Scanner txt = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		
		String user;
		String pass;
		
		System.out.println("What is your username?");
		user = txt.nextLine();
		System.out.println("What is your password?");
		pass = txt.nextLine();
		Employee employee = edi.getEmployee(user, pass);
		System.out.println(employee);
		
	}
	
}
