package com.alarq.StudManRESTClient.entity;

import java.sql.Date;


public class StudentDetails {
	
	private int id;
	private Date birthDate;
	private String birthPlace;
	private String address;

	public StudentDetails() {}
	
	public StudentDetails(int id, Date birthDate, String birthPlace, String address) {
		super();
		this.id = id;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.address = address;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", birthDate=" + birthDate + ", birthPlace=" + birthPlace + ", address="
				+ address + "]";
	}
	
	
	
}
