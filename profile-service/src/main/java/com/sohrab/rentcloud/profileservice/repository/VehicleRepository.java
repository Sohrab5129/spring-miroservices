package com.sohrab.rentcloud.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sohrab.rentcloud.commons.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
