package com.app.dao;

import java.util.List;

import com.app.pojos.Student;

public interface StudentDao {
	List<Student> getAllStudents();
	Student getStudentById(int sid);
	String registerStudent(Student s);
	String updateStudent(Student s);
	String deleteStudentDtls(Student s);
	
}
