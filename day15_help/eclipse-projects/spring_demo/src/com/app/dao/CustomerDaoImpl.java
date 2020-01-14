package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Customer validateCustomer(String em, String pass) {
		return  sf
				.getCurrentSession()
				.createQuery(
						"select c from Customer c where c.email = :em and c.password = :pa",Customer.class)
				.setParameter("em", em).setParameter("pa", pass).getSingleResult();
	}

	@Override
	public Customer registerCustomer(Customer cust) {
		
		 sf.getCurrentSession().persist(cust);
		 return cust;
	}

	
	@Override
	public List<Customer> listCustomers() {
		
		return sf.getCurrentSession().createQuery(
				"select c from Customer c",Customer.class).getResultList();
	}
	
	
}
