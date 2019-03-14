package com.example.wheather.entity;

import java.util.List;

public class UserAndCitiesByType {

	private String firstname;
	
	private String eMail;
	
	private List<String> cities;

	public UserAndCitiesByType() {
		super();
	}

	public UserAndCitiesByType(String firstname, String eMail, List<String> cities) {
		super();
		this.firstname = firstname;
		this.eMail = eMail;
		this.cities = cities;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "UserAndCitiesByType [firstname=" + firstname + ", eMail=" + eMail + ", cities=" + cities + "]";
	}
	
	
}
