package com.dealership.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dealership.model.Payment;
import com.dealership.service.PaymentMethods;

class DealershipTests {
	Payment payment = new Payment(2, 30000, 1,2);
	@Test
	void test() {
		PaymentMethods.subtractPayment(payment.getPayment_id(), 200);
		System.out.println(payment.getOriginal_amount());
		assertEquals(29800, payment.getOriginal_amount());
	}

}
