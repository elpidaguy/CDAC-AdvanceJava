package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

@RestController // @Controller + @ResponseBody on ret types of req handling methods
@RequestMapping("/vendors")
public class VendorController {
	// dep
	@Autowired
	private IVendorDao dao;

	public VendorController() {
		System.out.println("in cnstr of "+getClass().getName());
	}
	@GetMapping("/{id}")
	public Vendor getDetails(@PathVariable int id)
	{
		System.out.println("in get vendor dtls "+id);
		return dao.getCompleteDetails(id);
	}
	
}
