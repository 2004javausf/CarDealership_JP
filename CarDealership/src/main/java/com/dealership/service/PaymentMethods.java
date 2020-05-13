package com.dealership.service;

import com.dealership.daoImpl.PaymentDAOImpl;
import com.dealership.model.Payment;

public class PaymentMethods {
	
	public static void subtractPayment(int payment_id, int amount) {
		PaymentDAOImpl pdi = new PaymentDAOImpl();
		Payment paymentAccount = pdi.getPayment(payment_id);
		paymentAccount.setOriginal_amount(paymentAccount.getOriginal_amount()- amount);
		pdi.updatePayment(paymentAccount);
	}
}
