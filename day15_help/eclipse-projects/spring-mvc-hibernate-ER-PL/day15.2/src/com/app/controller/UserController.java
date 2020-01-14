package com.app.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IUserDao;
import com.app.pojos.User;
import com.app.pojos.UserRole;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependency
	@Autowired
	private IUserDao dao;

	public UserController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// request handling method to show login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	// request handling method process login form
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String em, 
			@RequestParam String pass, Model map,
			HttpSession hs,RedirectAttributes flashMap) {
		System.out.println("in process login form " + em + " " + pass);
		try {
			// invoke Dao's method
			User u = dao.authenticateUser(em, pass);
			// valid login -- store mesg(last action taken) under flash scope (till next request)
			flashMap.addFlashAttribute("mesg", "Login Successful : "+u.getRole());
			//add validated user dtls under sesison scope to be remembered till logout
			hs.setAttribute("user_dtls", u);
			// check role
			if (u.getRole().equals(UserRole.ADMIN))
				return "redirect:/admin/list";//redirect
			return "redirect:/vendor/details";//redirect

		} catch (RuntimeException e) {
			System.out.println("err in process login " + e);
			// forward clnt to login form , highlighted with errs
			map.addAttribute("mesg", "Invalid Login , Pls retry");
			return "/user/login";//forward view
		}

	}
	//request handling method for user's logging out
	@GetMapping("/logout")
	public String logoutUser(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("in user's logout");
		//get user dtls from session scope & them under model map
		map.addAttribute("details", hs.getAttribute("user_dtls"));
		//discard HS
		hs.invalidate();
		//set refresh header to auto navigate the clnt to index page --after a dly
		response.setHeader("refresh", "5;url="+request.getContextPath());
		return "/user/logout";//forward view
	}

}
