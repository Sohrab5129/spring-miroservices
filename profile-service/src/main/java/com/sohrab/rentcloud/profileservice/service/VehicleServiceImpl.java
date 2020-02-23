package com.sohrab.rentcloud.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sohrab.rentcloud.commons.model.Vehicle;
import com.sohrab.rentcloud.profileservice.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		return vehicleRepository.findAll();
	}

	@Override
	public Optional<Vehicle> getVehicleById(Integer id) {
		return vehicleRepository.findById(id);
	}

}
