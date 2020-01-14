package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojos.Employee;

@Repository
@Transactional
public class EmpDao implements EmpDaoIntf {
	@Autowired
	private SessionFactory sf;

	@Override
	public String hireEmp(Employee e) {
		sf.getCurrentSession().save(e);
		return "Emp hired successfully Id : "+e.getKey();
	}

}
