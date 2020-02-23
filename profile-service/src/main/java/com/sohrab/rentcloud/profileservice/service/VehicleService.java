package com.sohrab.rentcloud.profileservice.service;

import java.util.List;
import java.util.Optional;

import com.sohrab.rentcloud.commons.model.Vehicle;

public interface VehicleService {

	Vehicle save(Vehicle vehicle);

	List<Vehicle> getAllVehicle();

	Optional<Vehicle> getVehicleById(Integer id);

}
