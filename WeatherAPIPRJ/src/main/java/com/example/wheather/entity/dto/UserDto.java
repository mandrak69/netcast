package com.example.wheather.entity.dto;

public class UserDto {

	private String firstname;
	
	private String surname;
	
	private String eMail;
	
	private String password;

	public UserDto() {
		super();
	}
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [firstname=" + firstname + ", surname=" + surname + ", eMail=" + eMail + ", password="
				+ password + "]";
	}
	
	
	
}
