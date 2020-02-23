package com.sohrab.rentcloud.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sohrab.rentcloud.commons.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
