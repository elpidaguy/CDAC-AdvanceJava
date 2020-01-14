package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Employee;
import com.app.service.IEmpService;

@RestController // =@Copntroller+@ResponseBody
//on all ret types of req handling methods.
@RequestMapping("/employees")
@CrossOrigin // origins=*

public class EmpController {
	@Autowired
	private IEmpService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST req handling method to get all emps
	@GetMapping
	public ResponseEntity<?> getAllEmps() {
		System.out.println("in gel all emps");
		// invoke service layer method to get emp list
		List<Employee> allEmps = service.getAllEmps();
		if (allEmps.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Employee>>(allEmps, HttpStatus.OK);
	}

	// REST req handling method to get emp dtls by id
	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmpDetails(@PathVariable int empId) {
		System.out.println("get emp dtls " + empId);
		Employee empDetails = service.getEmpDetails(empId);
		if (empDetails == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Employee>(empDetails, HttpStatus.OK);
	}

	// REST req handling method to add emp dtls
	/*
	 * @PostMapping public ResponseEntity<?> saveEmpDtls(@RequestBody Employee e) {
	 * System.out.println("in save emp " + e); try { return new
	 * ResponseEntity<Employee>( service.addNewEmpDetails(e), HttpStatus.CREATED); }
	 * catch (RuntimeException e1) { e1.printStackTrace();// only for debugging
	 * return new ResponseEntity<Void> (HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 */
	@PostMapping
	public ResponseEntity<?> saveEmpDtls(@RequestParam String name, @RequestParam String address,
			@RequestParam(value = "image", required = false) MultipartFile image) {
		System.out.println("in save emp " + name + " " + address);

		try {
			Employee e = new Employee(name, address);
			if (image != null) {
				// image is supplied
				e.setImage(image.getBytes());
			}
			return new ResponseEntity<Employee>(service.addNewEmpDetails(e), HttpStatus.CREATED);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmpDetails(@PathVariable int empId) {
		System.out.println("del emp dtls " + empId);
		service.deleteEmp(empId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping("/{empId}")
	public ResponseEntity<?> updateEmpDtls(@RequestParam String name, @RequestParam String address,
			@RequestParam(value = "image", required = false) MultipartFile image, @PathVariable int empId) {
		System.out.println("in update emp " + empId + " " + name + " " + address);

		Employee empDetails = service.getEmpDetails(empId);
		if (empDetails == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // emp found try {
		empDetails.setName(name);
		empDetails.setAddress(address);
		try {
			if (image != null) { // image is supplied
				empDetails.setImage(image.getBytes());
			}
			return new ResponseEntity<Employee>(service.updateEmpDetails(empDetails), HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
