package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	public WelcomeController() {
		System.out.println("in WelcomeController CTOR");
	}
	
	@RequestMapping("/welcome")
	public String Welcome()
	{
		return "welcome";
	}
	
	@RequestMapping("/welcomewithview")
	public ModelAndView WelcomeWithView()
	{
		return new ModelAndView("WelcomeWithView", "timedate", LocalDateTime.now());
	}
	
}
