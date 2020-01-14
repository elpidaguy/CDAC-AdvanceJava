package com.app.dao;

import java.util.List;

import com.app.pojos.Customer;

public interface CustomerDao {
	Customer validateCustomer(String em,String pass);
	Customer registerCustomer(Customer cust);
	List<Customer> listCustomers();

}
