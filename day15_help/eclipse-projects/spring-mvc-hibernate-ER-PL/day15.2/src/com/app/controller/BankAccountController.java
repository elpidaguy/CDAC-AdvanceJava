package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IBankAccountDao;
import com.app.pojos.AcType;
import com.app.pojos.BankAccount;
import com.app.pojos.User;

@Controller
@RequestMapping("/account")
public class BankAccountController {
	@Autowired
	private IBankAccountDao dao;

	public BankAccountController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@ModelAttribute(name = "ac_types")
	public AcType[] getAcTypes() {
		System.out.println("model attr method : for ac types");
		return AcType.values();
	}

	// request handling method to create new a/c
	@GetMapping("/create")
	public String showCreateAcForm(Model map) {
		System.out.println("show create a/c form");
		return "/account/create";
	}

	// request handling method to process creation of new a/c
	@PostMapping("/create")
	public String processCreateAcForm(@RequestParam double balance, 
			@RequestParam AcType acType,
			RedirectAttributes flashMap, HttpSession hs) {
		System.out.println("process create a/c form " + balance + " " + acType);
		User u = (User) hs.getAttribute("user_dtls");
		BankAccount a = new BankAccount(acType, balance);// transient pojo
		//u -- detached pojo , a -- transient pojo
		flashMap.addAttribute("mesg", dao.createNewAccount(u, a));
		return "redirect:/vendor/details";
	}

	// request handling method to close vendor's bank account
	@PostMapping("/close")
	public String closeAccount(@RequestParam int acId, 
			HttpSession hs, RedirectAttributes flashMap) {
		System.out.println("in a/c close " + acId);
		User u = (User) hs.getAttribute("user_dtls");
		flashMap.addAttribute("mesg", dao.closeAccount(u.getId(), acId));
		return "redirect:/vendor/details";

	}

}
