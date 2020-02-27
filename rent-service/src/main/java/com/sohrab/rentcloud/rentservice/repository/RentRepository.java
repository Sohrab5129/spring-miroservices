package com.sohrab.rentcloud.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codelabs.rentcloud.model.rent.Rent;

public interface RentRepository extends JpaRepository<Rent, Integer> {

}
