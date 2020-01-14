package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICourseDao;
import com.app.pojos.Course;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private ICourseDao dao;

	@Override
	public String selectCourse(int sid, int courseId) {
		// TODO Auto-generated method stub
		return dao.selectCourse(sid, courseId);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return dao.getAllCourses();
	}
	

}
