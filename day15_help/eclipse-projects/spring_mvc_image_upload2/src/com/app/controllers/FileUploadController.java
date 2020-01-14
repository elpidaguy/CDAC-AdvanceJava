package com.app.controllers;

import java.io.File;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@Value("${upload_image_path}")
	private String imagePath;

	// Usage of path variable --for reducing number of request handling methods 
	//for simply forwarding user to view layer.
	@RequestMapping(value = "/{path}")
	public String showForm(@PathVariable String path) {
		System.out.println("in show upload form "+path);
		return path;
	}

	@PostMapping(value = "/file_upload")
	public String uploadFile(@RequestParam("contents") MultipartFile file, Model map) {
		String uploadLocation = imagePath;
		System.out.println(
				"in upload file " + file.getOriginalFilename() 
				+ " size " + file.getSize() + " upload loc " + uploadLocation);
		try {
			File dest = new File(uploadLocation, 
					file.getOriginalFilename());
			// file transferred to server side folder --supplied via upload location
			file.transferTo(dest);
		} catch (Exception e) {
			map.addAttribute("mesg", "File upload failed : " + e.getMessage());
			return "file_upload";
		}
		return "upload_succ";
	}

	// get list of images under the uploaded location
	@RequestMapping(value = "/list_images")
	public String listImages(Model map) {
		System.out.println("in list images " + imagePath);
		File uploadLocationDir = new File(imagePath);
		System.out.println(uploadLocationDir.exists() + " " + uploadLocationDir.isDirectory() + " "
				+ uploadLocationDir.getAbsolutePath());
		
		String[] files = uploadLocationDir.list();
		System.out.println("files " + Arrays.toString(files));
		map.addAttribute("image_list", files);
		return "list_images";
	}

	//add chosen image name under model map
	@PostMapping(value = "/choose")
	public String chooseImage(Model map, @RequestParam String imgName) {
		System.out.println("in choose img name " + imgName);
		map.addAttribute("img_name", imgName);
		return "show_image";
	}

}
