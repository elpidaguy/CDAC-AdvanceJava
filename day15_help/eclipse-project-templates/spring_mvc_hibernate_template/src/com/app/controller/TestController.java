package com.app.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in constr "+getClass().getName());
	}
	@GetMapping("/hello") 
	public String testMe()
	{
		
		return "/test/welcome";
	}
	
}
