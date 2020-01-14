package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.pojos.Customer;

@Service("dao_based_service")
@Transactional
public class CustomerDaoBasedService implements CustomerService {
	@Autowired
	private CustomerDao dao;

	@Override
	public List<Customer> listCustomers() {
		// TODO Auto-generated method stub
		return dao.listCustomers();
	}

	@Override
	public Customer validateCustomer(String email, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

}
