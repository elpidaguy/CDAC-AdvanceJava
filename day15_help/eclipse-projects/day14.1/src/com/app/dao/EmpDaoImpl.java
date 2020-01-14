package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;

@Repository
public class EmpDaoImpl implements IEmpDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Employee> getAllEmps() {
		String jpql = "select e from Employee e";
		return sf.getCurrentSession().
				createQuery(jpql, Employee.class).getResultList();
	}

	@Override
	public Employee getEmpDetailsById(int empId) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Employee.class, empId);
	}

	@Override
	public Employee addNewEmpDetails(Employee e) {
		//e --transient
		sf.getCurrentSession().persist(e);//persistent
		return e;
	}

	@Override
	public void deleteEmp(Employee e) {
		sf.getCurrentSession().delete(e);
		
	}

	@Override
	public Employee updateEmpDetails(Employee e) {
		sf.getCurrentSession().update(e);
		return e;
	}
	
	
	

}
