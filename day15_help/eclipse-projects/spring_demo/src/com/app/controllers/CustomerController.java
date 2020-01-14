package com.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

@Controller
// mandatory
@RequestMapping("/cust")
// optional
public class CustomerController {
	@Autowired
	@Qualifier("cust_dao_service")
	private CustomerService service;

	@RequestMapping(value = "/list")
	public String listCustomers(Model map) {
		System.out.println("list custs");
		map.addAttribute("cust_list", service.getAllCustomers());
		return "list";
	}

	@RequestMapping(value = "/validate")
	public String showLoginForm(Customer cust) {
		System.out.println("in show login form " + cust);

		// map.addAttribute(new Customer());
		return "login";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	// public @ResponseBody String processLoginForm(@ModelAttribute("cust123")
	// CustomerPOJO cust) {
	public String processLoginForm(@Valid Customer cust123, BindingResult result, Model map) {
		System.out.println("in process login form");
		System.out.println("cust details " + cust123);
		// check for P.L validation errs
		if (result.hasFieldErrors("email") || result.hasFieldErrors("password")) {
			System.out.println("p.l errs : in validate");
			return "login";
		}
		System.out.println("no p.l errs");
		Customer validCust = null;
		// invoke service layer method
		try {
			validCust = service.validateCustomer(cust123.getEmail(), cust123.getPassword());
		} catch (RuntimeException e) {
			map.addAttribute("mesg", "Login Invalid , Pls retry");
			return "login";
		}

		map.addAttribute("valid_cust", validCust);
		map.addAttribute("status", "Login Successful");
		return "valid";
	}

	// controller method to display reg form
	@RequestMapping(value = "/register")
	public String showRegForm(Customer cust) {
		System.out.println("in show reg form " + cust);
		// map.addAttribute(new Customer());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegForm(Customer cust123, Model map, HttpSession hs) {
		System.out.println("in process reg form");
		System.out.println("cust details " + cust123);
		// invoke service layer method
		Customer validCust = service.registerCustomer(cust123);
		if (validCust.getId() == null) {
			map.addAttribute("mesg", "Reg Invalid , Pls retry");
			return "register";
		}
		hs.setAttribute("valid_cust", validCust);
		hs.setAttribute("status", "Reg Successful");
		return "redirect:/valid";// replace forward by redirect
	}
}
