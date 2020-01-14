package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.pojos.Customer;

@Controller
public class BootstrapController {
	@GetMapping("/{path}")
	public String globalMapping(@PathVariable String path,Customer c)
	{
		System.out.println("in global mapping "+path);
		return path;
	}
	@PostMapping("/test_bootstrap")
	public String testMe(Customer c)
	{
		return "test";
	}

}
