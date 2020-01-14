package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	public HomeController() {
		System.out.println("home controller");
	}
	@GetMapping
	public String showHomePage()
	{
		System.out.println("in show home page");
		return "/index";
	}
}
