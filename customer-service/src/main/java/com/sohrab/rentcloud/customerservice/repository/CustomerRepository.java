package com.sohrab.rentcloud.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codelabs.rentcloud.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
