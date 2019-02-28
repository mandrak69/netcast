package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity

public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
     
    private String name;
    private String email;
    
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User( String name, String email) {
		super();
		
		this.name = name;
		this.email = email;
	}


	public long getId() {
		return id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
     
    
    
    // standard constructors / setters / getters
}
