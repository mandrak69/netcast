package com.example.wheather.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {

	@Id
	private String id;
	
	private String firstname;
	
	private String surname;
	
	private String eMail;
	
	private String password;
	
	private List<Subscription> subsciptions;
	

	public User() {
		super();
	}

	public User(String id, String firstname, String surname, String eMail, String password, List<Subscription> subscriptions) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.eMail = eMail;
		this.password = password;
		this.subsciptions= subscriptions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<Subscription> getSubsciptions() {
		return subsciptions;
	}

	public void setSubsciptions(List<Subscription> subsciptions) {
		this.subsciptions = subsciptions;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", eMail=" + eMail
				+ ", password=" + password + ", subsciptions=" + subsciptions + "]";
	}

	
	
	

	
	
}
