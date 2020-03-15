package com.alarq.StudManRESTClient.entity;

import java.util.ArrayList;
import java.util.List;


public class Course {
	

	private int id;
	private String name;
	private String term;
	private List<Student> students;
	
	public int getId() {
		return id;
	}
	
	public void addStudent(Student student)
	{
		if(students ==null)
			students = new ArrayList<Student>();
		students.add(student);
	}
	
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", term=" + term + "]";
	}
	
	
}
