package com.sohrab.rentcloud.rentservice.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.sohrab.rentcloud.rentservice.hystrix.CommonHystrixCommand;
import com.sohrab.rentcloud.rentservice.model.DetailResponse;
import com.sohrab.rentcloud.rentservice.repository.RentRepository;

import codelabs.rentcloud.model.customer.Customer;
import codelabs.rentcloud.model.rent.Rent;
import codelabs.rentcloud.model.vehicle.Vehicle;

@Service
public class RentServiceImpl implements RentService {

	@Autowired
	HystrixCommand.Setter setter;
	
	@Autowired
	RentRepository rentRepository;

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Rent save(Rent customer) {
		return rentRepository.save(customer);
	}

	@Override
	public Rent findById(int id) {
		Optional<Rent> rent = rentRepository.findById(id);

		if (rent.isPresent())
			return rent.get();
		else
			return new Rent();

	}

	@Override
	public List<Rent> findAll() {
		return rentRepository.findAll();
	}

	@Override
	public DetailResponse findDetailResponse(int id) throws InterruptedException, ExecutionException {

		Rent rent = findById(id);
		Customer customer = getCustomer(rent.getCustomerId());
		Vehicle vehicle = getVehicle(rent.getVehicleId());

		return new DetailResponse(rent, customer, vehicle);

	}

	public DetailResponse findDetailResponsefallback() {
		return new DetailResponse(new Rent(), new Customer(), new Vehicle());
	}

	private Customer getCustomer(int customerId) throws InterruptedException, ExecutionException {

		CommonHystrixCommand<Customer> commonHystrixCommand = new CommonHystrixCommand<>(setter, () -> {
			return restTemplate.getForObject("http://customer/services/customers/" + customerId, Customer.class);
		}, () -> {
			return new Customer();
		});

		Future<Customer> customer = commonHystrixCommand.queue();
		return customer.get();

//		Customer customer = restTemplate.getForObject("http://customer/services/customers/" + customerId,
//				Customer.class);
//		return customer;

	}

	private Vehicle getVehicle(int vehicleId) throws InterruptedException, ExecutionException {

		
		CommonHystrixCommand<Vehicle> commonHystrixCommand = new CommonHystrixCommand<>(setter, () -> {
			return restTemplate.getForObject("http://vehicle/services/vehicles/" + vehicleId, Vehicle.class);
		}, () -> {
			return new Vehicle();
		});

		Future<Vehicle> vehicle = commonHystrixCommand.queue();
		return vehicle.get();
		
//		VehicleCommand command = new VehicleCommand(restTemplate, vehicleId);
//		return command.execute();
		//return restTemplate.getForObject("http://vehicle/services/vehicles/" + vehicleId, Vehicle.class);

	}
}
