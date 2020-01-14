package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("in hello cnstr...");
	}
	@GetMapping("/hello")
	public String sayHello() {
		System.out.println("in say hello");
		return "welcome";
	}
}
