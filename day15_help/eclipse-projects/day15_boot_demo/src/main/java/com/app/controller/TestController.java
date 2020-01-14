package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class TestController {
	@GetMapping
	public List<Integer> testMe() {
		System.out.println("in test me...");
		return Arrays.asList(10, 20, 30, 40);
	}
}
