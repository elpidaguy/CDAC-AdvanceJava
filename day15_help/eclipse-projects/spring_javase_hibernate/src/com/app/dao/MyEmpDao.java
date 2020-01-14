package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojos.MyEmp;

@Repository
@Transactional
public class MyEmpDao implements MyEmpDaoIntf {
	@Autowired
	private SessionFactory sf;

	@Override
	public String hireEmp(MyEmp e) {
		sf.getCurrentSession().save(e);
		return "Emp hired successfully Id : "+e.getEmpId();
	}

}
