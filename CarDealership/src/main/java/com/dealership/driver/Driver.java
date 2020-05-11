package com.dealership.driver;

import com.dealership.dao.OfferDAO;
import com.dealership.daoImpl.OfferDAOImpl;

public class Driver {
	public static void main(String[] args) {
		//MainMenu.start();
		OfferDAO odi = new OfferDAOImpl();
		odi.makeOffer(2300, 1,4);
	}
}
