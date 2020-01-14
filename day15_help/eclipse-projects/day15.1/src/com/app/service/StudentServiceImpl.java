package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentDao;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDao dao;

	@Override
	public Student getStudentDetails(int sid) {
		// TODO Auto-generated method stub
		Student s= dao.getStudentDetails(sid);
		//invoke non id getter within session scope
		System.out.println(s.getName());
		return s;
	}

}
