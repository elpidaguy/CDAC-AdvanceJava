package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.Student;

@Repository
public class CourseDaoImpl implements ICourseDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public String selectCourse(int sid, int courseId) {
		String mesg = "student's course selection failed";
		Session hs = sf.getCurrentSession();
		// get student dtls from sid
		Student s = hs.get(Student.class, sid);
		// get course dtls from course id
		Course c = hs.get(Course.class, courseId);
		// validate student n course
		if (s != null && c != null) {
			// c & s --persistent
			c.addStudent(s);// changing state of persistent POJO
			mesg = s.getName() + " admitted in course " + c.getName();
		}
		// helper method to add stud to acourse & vice versa
		return mesg;
	}

	@Override
	public List<Course> getAllCourses() {
		String jpql = "select distinct c from Course c left outer join fetch c.students";
		return sf.getCurrentSession().createQuery(jpql, Course.class).getResultList();
	}

}
