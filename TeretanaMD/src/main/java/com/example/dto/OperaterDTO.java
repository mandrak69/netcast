package com.example.dto;

public class OperaterDTO {
	
	private String email;
	private String password;
	
	
	
	public OperaterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "OperaterDTO [email=" + email + ", password=" + password + "]";
	}
	
}
