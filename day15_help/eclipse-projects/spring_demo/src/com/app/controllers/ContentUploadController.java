package com.app.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ContentUploadController {
	
	@Value("#{props.upload_location}")
	private String location;

	@GetMapping(value = "/upload")
	public String showForm() {
		System.out.println("in show form");
		return "upload";
	}

	@PostMapping(value = "/upload")
	public String uploadContents(@RequestParam MultipartFile contents, Model map) {
		System.out.println("in upload conts " + contents.getContentType() + " " + contents.getSize());
		try {
			contents.transferTo(new File(location, contents.getOriginalFilename()));
		} catch (Exception e) {
			map.addAttribute("mesg", "Content Upload failed " + e.getMessage());
			return "upload";
		}
		map.addAttribute("mesg",
				contents.getOriginalFilename() + " uploaded successfully , content type " + contents.getContentType());
		return "upload_succ";
	}
}
