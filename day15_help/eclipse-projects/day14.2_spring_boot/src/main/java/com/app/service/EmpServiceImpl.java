package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmpDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService {
	@Autowired
	private IEmpDao dao;

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return dao.getAllEmps();
	}

	@Override
	public Employee getEmpDetails(int id) {
		// TODO Auto-generated method stub
		return dao.getEmpDetailsById(id);
	}

	@Override
	public Employee addNewEmpDetails(Employee e) {
		// TODO Auto-generated method stub
		return dao.addNewEmpDetails(e);
	}
	
	@Override
	public void deleteEmp(int empId) {
		Employee empById = dao.getEmpDetailsById(empId);
		if(empById != null)
			dao.deleteEmp(empById);
		
	}

	@Override
	public Employee updateEmpDetails(Employee e) {
		// TODO Auto-generated method stub
		return dao.updateEmpDetails(e);
	}
	

	
	
	

}
