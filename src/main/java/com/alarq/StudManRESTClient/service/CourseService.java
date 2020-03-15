package com.alarq.StudManRESTClient.service;

import java.util.List;

import com.alarq.StudManRESTClient.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public void saveCourse(Course course);
	public Course getCourse(int id);
	public void deleteCourse(int id);
}
