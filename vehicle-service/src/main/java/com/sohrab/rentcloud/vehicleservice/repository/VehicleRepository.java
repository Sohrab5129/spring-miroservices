package com.sohrab.rentcloud.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codelabs.rentcloud.model.vehicle.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
