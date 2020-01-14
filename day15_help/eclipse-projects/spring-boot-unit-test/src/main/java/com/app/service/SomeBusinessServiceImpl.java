package com.app.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class SomeBusinessServiceImpl implements SomeBusinessService {

	@Override
	public int calcSum(int... data) {

		return Arrays.stream(data).sum();
	}

}
