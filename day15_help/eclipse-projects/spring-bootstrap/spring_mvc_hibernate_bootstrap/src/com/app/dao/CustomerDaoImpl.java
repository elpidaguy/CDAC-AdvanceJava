package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	// dependency
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Customer> listCustomers() {

		return sf.getCurrentSession().createQuery
				("select c from Customer c",Customer.class).getResultList();
	}

}
