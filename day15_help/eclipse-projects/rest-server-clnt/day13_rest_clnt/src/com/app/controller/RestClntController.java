package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.app.dto.StudentDTO;

@Controller
@RequestMapping("/rest_clnt")
public class RestClntController {
	@Value("#{abc.GET_URL}")
	private String getURL;

	@Value("#{abc.POST_URL}")
	private String postURL;

	@GetMapping("/show_dtls")
	public String showStudentIdForm() {
		return "/rest_clnt/show_dtls";
	}

	@PostMapping("/show_dtls")
	public String processStudentIdForm(@RequestParam int sid, RestTemplate template, Model map) {
		System.out.println("rest clnt : process stud id " + sid);
		// REST call
		try {
			ResponseEntity<StudentDTO> resp = template.getForEntity(getURL, StudentDTO.class, sid);
			map.addAttribute("status", "Success : " + resp.getBody());
		} catch (RestClientResponseException e) {
			System.out.println("err in rest clnt " + e);
			map.addAttribute("status", e.getResponseBodyAsString() + " " + e.getStatusText());
		}
		return "/rest_clnt/details";
	}

	@GetMapping("/register_student")
	public String showStudentRegForm(StudentDTO s) {
		return "/rest_clnt/register";
	}

	// req handling method for processing form.
	@PostMapping("/register_student")
	public String processRegStudent(@Valid StudentDTO s,BindingResult result, Model map, RestTemplate template) {
		System.out.println("in proc reg " + s);
		//chk for P.L errs
		if(result.hasErrors())
		{
			System.out.println("p.l errs");
			return "/rest_clnt/register";
		}
		System.out.println("proceeding to B.L");
		try {
			// REST call for creating a resource
			map.addAttribute("status", template.postForObject(postURL, s, String.class));
		} catch (RestClientResponseException e) {
			map.addAttribute("status", e.getResponseBodyAsString() + " " + e.getMessage());
		}
		return "/rest_clnt/details";
	}

}
