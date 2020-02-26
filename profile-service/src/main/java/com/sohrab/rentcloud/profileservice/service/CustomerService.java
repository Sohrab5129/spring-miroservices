package com.sohrab.rentcloud.profileservice.service;

import java.util.List;
import java.util.Optional;

import com.sohrab.rentcloud.commons.model.Customer;

public interface CustomerService {

	Customer save(Customer customer);

	List<Customer> getAllProfile();

	Optional<Customer> getProfileById(Integer id);
}
