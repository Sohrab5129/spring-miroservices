package com.sohrab.rentcloud.vehicleservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sohrab.rentcloud.vehicleservice.repository.VehicleRepository;

import codelabs.rentcloud.model.vehicle.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public Vehicle save(Vehicle customer) {
		return vehicleRepository.save(customer);
	}

	@Override
	public Vehicle findById(int id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);

		if (vehicle.isPresent())
			return vehicle.get();
		else
			return new Vehicle();

	}

	@Override
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
}
