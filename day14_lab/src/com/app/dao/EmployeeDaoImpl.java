package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Department;
import com.app.pojos.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public String hireEmployee(int deptId,Employee e) {
		Department d = sf.getCurrentSession().get(Department.class, deptId);
		if(d!=null)
		{
			d.addEmployee(e);
			return "Employee Hired Successfully!";
		}
		
		return "Please come again :)";
	}

}
