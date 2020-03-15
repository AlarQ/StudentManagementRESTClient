package com.alarq.StudManRESTClient.service;

import java.util.List;

import com.alarq.StudManRESTClient.entity.Student;

public interface StudentService {
	
	public List<Student> get();
	public void save(Student student);
	public Student get(int id);
	public void delete(int id);
}
