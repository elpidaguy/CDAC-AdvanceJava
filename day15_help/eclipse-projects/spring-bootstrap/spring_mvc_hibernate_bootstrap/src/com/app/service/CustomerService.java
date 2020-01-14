package com.app.service;

import java.util.List;

import com.app.pojos.Customer;

public interface CustomerService {
	List<Customer> listCustomers();
	Customer validateCustomer(String email,String pass);
	String registerCustomer(Customer c);

}
