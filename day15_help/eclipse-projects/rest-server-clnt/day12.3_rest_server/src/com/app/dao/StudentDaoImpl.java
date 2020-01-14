package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	// dependency
	@Autowired // byType
	private SessionFactory factory;

	@Override
	public List<Student> getAllStudents() {
		String jpql = "select s from Student s";
		return factory.getCurrentSession().createQuery(jpql, Student.class).getResultList();
	}

	@Override
	public Student getStudentById(int sid) {

		return factory.getCurrentSession().get(Student.class, sid);
	}

	@Override
	public String registerStudent(Student s) // transient
	{
		factory.getCurrentSession().persist(s);
		return "Student registered with ID " + s.getId();
	}

	@Override
	public String updateStudent(Student s) // detached
	{
		factory.getCurrentSession().update(s);
		return "Student updated with ID " + s.getId();
	}

	@Override
	public String deleteStudentDtls(Student s) {
		factory.getCurrentSession().delete(s);
		return "Student rec deleted  with ID " + s.getId();
	}

}
