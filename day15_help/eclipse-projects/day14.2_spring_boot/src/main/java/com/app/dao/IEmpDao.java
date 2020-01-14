package com.app.dao;

import com.app.pojos.Employee;

import java.util.List;

public interface IEmpDao {
	List<Employee> getAllEmps();
	Employee getEmpDetailsById(int empId);
	Employee addNewEmpDetails(Employee e);
	void deleteEmp(Employee e);
	Employee updateEmpDetails(Employee e);
	
}
