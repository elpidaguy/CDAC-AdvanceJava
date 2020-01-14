package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Student;
import org.hibernate.*;

@Repository
public class StudentDaoImpl implements IStudentDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Student getStudentDetails(int sid) {
	//	String jpql = "select s from Student s join fetch s.selectedCourses where s.studentId=:id";
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Student.class, sid);
	//	return sf.getCurrentSession().createQuery(jpql, Student.class).setParameter("id", sid).getSingleResult();

	}

}
