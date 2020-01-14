package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // combo of @Controller at cls level + @ResponseBody anno on ret types of ALL
				// req handling methods(@ReqMapping or its sub type
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in constr " + getClass().getName());
	}

	@GetMapping
	public List<Integer> testMe() {
		System.out.println("in test me");
		return Arrays.asList(1, 2, 3, 54, 67);
	}
}
