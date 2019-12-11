package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IVoterDao;
import com.app.pojos.Voter;

@Controller
@RequestMapping("/voter")
public class VoterController {

	//dependency
	@Autowired
	private IVoterDao ivd;
	
	public VoterController() {
		System.out.println("VoterController CTOR Called");
	}
	
	@GetMapping("/login")  //=@RequestMapping + method = get
	public String loadLogin()		//show login form
	{
		System.out.println("inside load login");
		return "/voter/login";
	}
	
	@PostMapping("/login") //=@RequestMapping + method = post
	public String processLogin(@RequestParam() String email, @RequestParam String password, Model map, HttpSession hs, RedirectAttributes ra)
	{
		Voter v = null;
		System.out.println("inside process login: "+email+" "+password+" "+map);
		try {
			v = ivd.authenticateVoter(email, password);
			hs.setAttribute("voter", v);
			System.out.println(v);
		} catch (RuntimeException e) {
			//add error msg in model map - request scope
			map.addAttribute("msg", "Invalid Login Please Retry!");
			//invalid login - forward cln to login 
			
			e.printStackTrace();
			
			return "/voter/login";
		}
		if(v.getStatus())
		{
			ra.addFlashAttribute("msg", "You have Already Voted Previously!");
			return "redirect:/voter/status";
		}
		else
		{
			map.addAttribute("msg", "Login Successfull");
			return "redirect:/candidate/listCandidates";
		}
	}
	
	@GetMapping("/status")
	public String setStatus(HttpSession hs, Model map)
	{
		Voter v = (Voter)hs.getAttribute("voter");
		if(!v.getStatus())
		{
			ivd.updateVotingStatus(v);
			map.addAttribute("msg", "Voted Successfully!");
		}
		return "/voter/status";
	}
	
	@GetMapping("/logout")
	public String Logout(HttpSession hs)
	{
		hs.invalidate();
		return "redirect:/voter/login";
	}

}
