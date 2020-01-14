package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustomerController {
	@Autowired
	@Qualifier("dao_based_service")
	private CustomerService service;

	@GetMapping(value = "/list")
	// @RequestMapping(....,method=RequestMethod.GET)
	public String listCustomers(Model map) {
		System.out.println("in list custs");
		map.addAttribute("cust_list", service.listCustomers());
		return "/cust1/list_all";
	}

	@GetMapping(value = "/validate")

	public String showLoginForm(Customer c) {
		System.out.println("in show login form " + c);
		return "/cust1/login";
	}

	@PostMapping(value = "/validate")

	public String processLoginForm(Customer c, Model map, HttpSession hs) {
		System.out.println("in process login form " + map);
		Customer c1 = service.validateCustomer(c.getEmail(), c.getPass());
		if (c1 == null) {
			map.addAttribute("mesg", "Invalid Login , Pls retry");
			return "/cust1/login";
		}
		// success
		// add cust details to session scope
		hs.setAttribute("cust_dtls", c1);
		// & redirect clnt to details page.
		// resp.sendRedirect(resp.encodeRedirectURL(....))
		return "redirect:/cust/details";
	}

	// URI --- /cust/details
	@GetMapping(value = "/details")
	public String showDetails() {
		System.out.println("in show dtls");
		return "/cust1/details";
	}

	// logout method
	@GetMapping(value = "/logout")
	public String logOut(HttpSession hs, Model map) {
		map.addAttribute("cust_dtls", hs.getAttribute("cust_dtls"));
		// discard session
		hs.invalidate();

		return "/cust1/logout";
	}

	@GetMapping(value = "/register")
	public String showRegForm(Customer c) {
		System.out.println("in show reg form " + c);
		return "/cust1/register";
	}

	@PostMapping(value = "/register")
	public String processForm(Customer c, Model map, HttpSession hs, RedirectAttributes flashMap) {
		System.out.println("in process reg form " + map);
		String regSts = service.registerCustomer(c);
		if (regSts.contains("Failed")) {
			map.addAttribute("mesg", regSts);
			return "/cust1/register";
		}
		// & redirect clnt to login page with reg success mesg
		// resp.sendRedirect(resp.encodeRedirectURL(....))
		hs.invalidate();
		flashMap.addFlashAttribute("mesg", regSts.concat(" Pls prceed to login"));
		return "redirect:/cust/validate";
	}

}
