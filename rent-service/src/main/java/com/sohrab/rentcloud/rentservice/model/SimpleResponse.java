package com.sohrab.rentcloud.rentservice.model;

import codelabs.rentcloud.model.rent.Rent;

public class SimpleResponse implements Response {

	Rent rent;

	public SimpleResponse(Rent rent) {
		this.rent = rent;
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}
}
