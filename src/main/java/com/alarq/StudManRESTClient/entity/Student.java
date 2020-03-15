package com.alarq.StudManRESTClient.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int year;
	private List<Course> courses;
	private StudentDetails studentDetails;
	public Student() {}

	public void addCourse(Course course)
	{
		if(courses == null)
			courses = new ArrayList<Course>();
		
		courses.add(course);
	}
	
	public StudentDetails getStudentDetails() {
		return studentDetails;
	}



	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}



	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", year=" + year + "]";
	}
}

