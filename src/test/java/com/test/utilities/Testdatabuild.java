package com.test.utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import pojo.Bookingdates;
import pojo.Bookings;

public class Testdatabuild {
	public Bookings createBookingPayload(String firstname, String lastname, String additionalneeds) {
		Bookings b=new Bookings();
		
		b.setFirstname(firstname);
		b.setLastname(lastname);
		b.setTotalprice(111);
		b.setDepositpaid(true);
		b.setAdditionalneeds(additionalneeds);
		
		Bookingdates date=new Bookingdates();
		date.setCheckin("2018-01-01");
		date.setCheckout("2019-01-01");
		b.setBookingdates(date);
		
		return b;
	}

	public static Map<String, String> setHeaders() {
		TreeMap<String, String> m=new TreeMap<String, String>();
		m.put("Content-Type", "application/json");
		m.put("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
		return m;
	}

}
