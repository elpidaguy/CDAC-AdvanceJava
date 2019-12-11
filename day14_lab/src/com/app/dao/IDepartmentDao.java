package com.app.dao;

import java.util.List;

import com.app.pojos.Department;
import com.app.pojos.Employee;

public interface IDepartmentDao {

	public List<Department> getAllDepartments();
	public String addNewEmployee(int dept_id, Employee e);
}
