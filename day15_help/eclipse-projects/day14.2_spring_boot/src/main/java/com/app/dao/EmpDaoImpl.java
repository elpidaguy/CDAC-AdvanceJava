package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;

@Repository
public class EmpDaoImpl implements IEmpDao {
	@PersistenceContext
	private EntityManager mgr;

	@Override
	public List<Employee> getAllEmps() {
		String jpql = "select e from Employee e";
		return mgr.unwrap(Session.class).
				createQuery(jpql, Employee.class).getResultList();
	}

	@Override
	public Employee getEmpDetailsById(int empId) {
		// TODO Auto-generated method stub
		return mgr.unwrap(Session.class).get(Employee.class, empId);
	}

	@Override
	public Employee addNewEmpDetails(Employee e) {
		//e --transient
		mgr.unwrap(Session.class).persist(e);//persistent
		return e;
	}

	@Override
	public void deleteEmp(Employee e) {
		mgr.unwrap(Session.class).delete(e);
		
	}

	@Override
	public Employee updateEmpDetails(Employee e) {
		mgr.unwrap(Session.class).update(e);
		return e;
	}
	
	
	

}
