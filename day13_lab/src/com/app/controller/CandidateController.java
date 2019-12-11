package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ICandidateDao;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private ICandidateDao icd;
	
	@GetMapping("/listCandidates")
	public String getCandidates(Model map)
	{
		map.addAttribute("candidateList",icd.getCandidateList());
		return "/candidate/listCandidates";
	}
	
	@PostMapping("/processVote")
	public String processVote(@RequestParam String cId,Model map, HttpSession hs)
	{
		System.out.println("inside process vote"+ cId+ " "+ map);
		try {
			icd.incrementVotes(Integer.parseInt(cId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/voter/status";
	}
}
