package com.sohrab.rentcloud.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sohrab.rentcloud.commons.model.Customer;
import com.sohrab.rentcloud.profileservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllProfile() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getProfileById(Integer id) {
		return customerRepository.findById(id);
	}

}
