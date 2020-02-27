package com.sohrab.rentcloud.rentprocesstask.service;

import org.springframework.stereotype.Service;

@Service
public class RentProcessServiceImpl implements RentProcessService {

	@Override
	public boolean validateDL(String dlNumber) {
		return dlNumber.length() > 5;
	}

}
