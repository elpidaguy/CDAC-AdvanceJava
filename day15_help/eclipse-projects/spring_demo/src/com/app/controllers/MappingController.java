package com.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@RequestMapping("/*")
public class MappingController {
	@RequestMapping
	public void passThrough(HttpServletRequest req)
	{
		System.out.println("in pass thro' "+req.getServletPath());
	//	return "valid";
	}

}
