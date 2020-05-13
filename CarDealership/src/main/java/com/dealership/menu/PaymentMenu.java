package com.dealership.menu;

import com.dealership.daoImpl.PaymentDAOImpl;

public class PaymentMenu {
	
	public static void viewPayments() {
		PaymentDAOImpl pdi = new PaymentDAOImpl();
		System.out.println(pdi.viewAllPayments());
	}
	
	public static void viewMyPayments(int customer_id) {
		PaymentDAOImpl pdi = new PaymentDAOImpl();
		System.out.println(pdi.viewCustomersPayments(customer_id));
	}
}
