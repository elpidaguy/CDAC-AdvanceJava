package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.pojos.Customer;

@Service("cust_dao_service")
@Transactional
public class CustomerDaoServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;

	@Override
	@Transactional(readOnly = true)
	public List<Customer> getAllCustomers() {
		
		return dao.listCustomers();
	}

	@Transactional(readOnly = true)
	@Override
	public Customer validateCustomer(String em, String pass) {

		return dao.validateCustomer(em, pass);
	}

	@Override
	public Customer registerCustomer(Customer cust) {
		
		return dao.registerCustomer(cust);
	}
	

}
