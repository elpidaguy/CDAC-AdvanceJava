package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IVendorDao;
import com.app.pojos.User;
import com.app.pojos.UserRole;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private IVendorDao dao;

	public VendorController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// request handling method to forward the clnt to details page
	@GetMapping("/details")
	public String showVendorDetails(HttpSession hs) {
		System.out.println("in show vendor dtls");

		User u = (User) hs.getAttribute("user_dtls");
		// invoke dao's method to fetch latest details of a vendor
		hs.setAttribute("user_dtls", dao.getCompleteDetails(u.getId()));
		return "/vendor/details";
	}

	

}
