package com.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Customer;

@Controller
@RequestMapping("/test")
public class HelloController {
	@RequestMapping(value = "/hello")
	public ModelAndView sayHello() {
		System.out.println("in say hello");
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
		return new ModelAndView("welcome", "num_list", l1);
	}

	@RequestMapping(value = "/hello1")
	public String sayHello1(Model map) {
		System.out.println("in say hello1 " + map);
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
		// add model attr
		map.addAttribute("num_list", l1);
		return "welcome";
	}

	@RequestMapping(value = "/hello2")
	// req param name MUST match with method arg name
	public String sayHello2(Model map, @RequestParam String name, @RequestParam int age, @RequestParam Date joinDate) {
		System.out.println("in say hello2 " + map);
		map.addAttribute("nm", name);
		map.addAttribute("user_age", age);
		map.addAttribute("join_date", joinDate);
		return "welcome";
	}

	@RequestMapping(value = "/hello3/{name}/{age}/{joinDate}")
	// URI template var name MUST match with method arg name
	public String sayHello3(Model map, @PathVariable String name, @PathVariable int age,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date joinDate) {
		System.out.println("in say hello3 " + map);
		map.addAttribute("nm", name);
		map.addAttribute("user_age", age);
		map.addAttribute("join_date", joinDate);
		return "welcome";
	}
	@RequestMapping(value = "/hello4")
	public String sayHello1(/*Model map,*/Customer c) {
		System.out.println("in say hello4");
     	return "welcome";
	}

}
