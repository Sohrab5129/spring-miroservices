package com.sohrab.rentcloud.rentservice.service;

import java.util.List;

import com.sohrab.rentcloud.rentservice.model.DetailResponse;

import codelabs.rentcloud.model.rent.Rent;

public interface RentService {
	Rent save(Rent customer);

	Rent findById(int id);

	List<Rent> findAll();

	DetailResponse findDetailResponse(int id);
}
