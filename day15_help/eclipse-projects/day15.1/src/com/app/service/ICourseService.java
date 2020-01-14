package com.app.service;

import java.util.List;

import com.app.pojos.Course;

public interface ICourseService {
	String selectCourse(int sid, int courseId);
	List<Course> getAllCourses();
}
