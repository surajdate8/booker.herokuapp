package com.test.constants;

public enum APIResources {
	CreateBooking("/booking"),
	GetBookingIds("/booking"),
	GetBooking("/booking/"),
	UpdateBooking("/booking/"),
	DeleteBooking("/booking/");
	
	private String resource;

	APIResources(String resource) {
		this.resource=resource;
	}
	public String getResource() {
		return resource;
	}


}
