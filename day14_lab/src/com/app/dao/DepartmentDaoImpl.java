package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Department;
import com.app.pojos.Employee;

@Repository
@Transactional
public class DepartmentDaoImpl implements IDepartmentDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Department> getAllDepartments() {
		String jpql = "select d from Department d";
		List<Department> deptList = sf.getCurrentSession().createQuery(jpql,Department.class).getResultList();
		
		for(Department d : deptList)
		{
			System.out.println(d.getEmpList().size());
		}
		
		return deptList;
	}

	@Override
	public String addNewEmployee(int dept_id, Employee e) {
		String msg = "Add Employee Failed";
		Department d = sf.getCurrentSession().get(Department.class, dept_id);
		if(d != null)
		{
			d.addEmployee(e);
			msg="Employee Added Successfully!";
		}
		return msg;
	}

}
