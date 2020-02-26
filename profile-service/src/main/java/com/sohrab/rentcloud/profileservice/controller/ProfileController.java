package com.sohrab.rentcloud.profileservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sohrab.rentcloud.commons.model.Customer;
import com.sohrab.rentcloud.profileservice.service.CustomerService;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('create_profile')")
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@GetMapping(value = "/customers")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@PreAuthorize("hasAuthority('read_profile')")
	public List<Customer> getAllProfile() {
		return customerService.getAllProfile();
	}

	@GetMapping(value = "/customers/{id}")
//	@PreAuthorize("hasAuthority('read_profile')")
	public Optional<Customer> getProfileById(@PathVariable("id") Integer id) {
		return customerService.getProfileById(id);
	}
}
