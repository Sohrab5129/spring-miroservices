package com.sohrab.rentcloud.vehicleservice.service;

import java.util.List;

import codelabs.rentcloud.model.vehicle.Vehicle;

public interface VehicleService {
	
	Vehicle save(Vehicle customer);

	Vehicle findById(int id);

	List<Vehicle> findAll();
}
