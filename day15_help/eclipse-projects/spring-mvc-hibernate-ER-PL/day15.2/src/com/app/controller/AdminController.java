package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IVendorDao;
import com.app.pojos.User;
import com.app.pojos.UserRole;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IVendorDao dao;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// request handling method for listing all vendors
	@GetMapping("/list")
	public String showVendorList(Model map) {
		System.out.println("in show vendor list");
		// invoke dao's method
		map.addAttribute("vendor_list", dao.listVendors());
		return "/admin/list";// forward view name
	}

	// request handling method to delete vendor details
	@GetMapping("/delete")
	public String deleteVendorDetails(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in del vendor dtls");
		// invoke dao's method
		flashMap.addFlashAttribute("mesg", dao.deleteVendorDetails(vid));
		// redirect view
		return "redirect:/admin/list";
	}

	@ModelAttribute(name = "user_roles")
	public UserRole[] getUserRoles() {
		System.out.println("model attr method for roles");
		return UserRole.values();
	}

	// request handling method to show vendor reg form
	@GetMapping("/register")
	public String showRegisterVendorForm(User u) {
		System.out.println("in show vendor reg form ");
		
		return "/admin/register";
	}

	// request handling method to process vendor reg form
	@PostMapping("/register")
		public String processRegisterVendorForm(@Valid User u,BindingResult result,RedirectAttributes flashMap) {
			System.out.println("in process vendor reg form "+u);
			//chk for P.L errors
			if(result.hasErrors())
			{
				System.out.println("P.L errors "+result);
				return "/admin/register";
			}
			//invoke dao's method for adding vendor record (insert)
			flashMap.addFlashAttribute("mesg", dao.registerVendor(u));
			return "redirect:/admin/list";
		}
	// request handling method to show vendor update form
		@GetMapping("/update")
		public String showUpdateVendorForm(@RequestParam int vid,Model map) {
			System.out.println("in show vendor update form " +vid);
			// fetch vendor details from DB & place it in model attribute for form binding
			User vendorDetails = dao.getVendorDetails(vid);
			System.out.println(vendorDetails);
			map.addAttribute("user",vendorDetails );
			return "/admin/update";
		}
		// request handling method to process vendor update  form
		@PostMapping("/update")
			public String processUpdateVendorForm( User u,RedirectAttributes flashMap) {
				System.out.println("in process vendor update form "+u);
				//invoke dao's method for updating vendor record (insert)
				flashMap.addFlashAttribute("mesg", dao.updateVendor(u));
				return "redirect:/admin/list";
			}

}
