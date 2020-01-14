package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class TestController {
	public TestController() {
		System.out.println("in test constr");
	}
	@GetMapping
	public List<Integer> testEndPoint()
	{
		System.out.println("in test end point");
		return Arrays.asList(10,20,30,40);
	}
}
