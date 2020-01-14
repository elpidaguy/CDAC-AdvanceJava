package com.app.dao;

import java.util.List;

import com.app.pojos.Course;

public interface ICourseDao {
	String selectCourse(int sid, int courseId);
	List<Course> getAllCourses();
}
