package com.app.service;

import java.util.List;

import com.app.pojos.Customer;

public interface CustomerService {
	 List<Customer> getAllCustomers();
	 Customer validateCustomer(String em,String pass);
	 Customer registerCustomer(Customer cust);
}
