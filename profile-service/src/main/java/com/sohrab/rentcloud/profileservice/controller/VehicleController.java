package com.sohrab.rentcloud.profileservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sohrab.rentcloud.commons.model.Vehicle;
import com.sohrab.rentcloud.profileservice.service.VehicleService;

@RequestMapping("/services")
@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping(value = "/vehicle")
	public Vehicle save(@RequestBody Vehicle vehicle) {
		return vehicleService.save(vehicle);
	}

	@GetMapping(value = "/vehicle")
	public List<Vehicle> getAllVehicle() {
		return vehicleService.getAllVehicle();
	}

	@GetMapping(value = "/vehicle/{id}")
	public Optional<Vehicle> getVehicleById(@PathVariable("id") Integer id) {
		return vehicleService.getVehicleById(id);
	}

}
