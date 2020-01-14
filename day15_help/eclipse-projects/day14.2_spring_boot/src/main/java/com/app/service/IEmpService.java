package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmpService {
	List<Employee> getAllEmps();
	Employee getEmpDetails(int id);
	Employee addNewEmpDetails(Employee e);
	void deleteEmp(int empId);
	Employee updateEmpDetails(Employee e);
}
