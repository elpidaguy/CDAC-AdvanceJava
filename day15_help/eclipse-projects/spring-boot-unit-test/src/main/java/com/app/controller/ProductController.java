package com.app.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello Controller Testing";
	}

	/*@GetMapping
	public String getProductDetailsAsString() {
		return new Product("Product", 1000, new Date()).toString();
	}*/

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return new Product("Prod" + id, id * 1000, new Date());
	}

	@PostMapping
	public String addProduct(@RequestBody Product p) {
		return "Product added successfully ..." + p;
	}

	// the product name should start with pr --if not return bad client request
	// other wise send product
	@GetMapping("/{name}/{price}")
	public ResponseEntity<?> showProductOrError(@PathVariable String name, @PathVariable double price) {
		if (name.startsWith("pr"))
			return new ResponseEntity<Product>(new Product(name, price, new Date()), HttpStatus.OK);
		return new ResponseEntity<String>("Invalid product name", HttpStatus.BAD_REQUEST);
	}
}
