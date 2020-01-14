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
		return dao.findAllEmps();
	}

	@Override
	public Employee getEmpDetails(int id) {
				return dao.findById(id).get();
	}

	@Override
	public Employee addNewEmpDetails(Employee e) {
		// TODO Auto-generated method stub
		return dao.save(e);
	}
	
	@Override
	public void deleteEmp(int empId) {
		dao.deleteById(empId);
		
	}

	@Override
	public Employee updateEmpDetails(Employee e) {
		return dao.save(e);
		
	}
	

	
	
	

}
