package com.example.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Operater   {

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	private Long id;
	
	private String ime;
	private String prezime;
	private String email;
	private String password;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "operater", cascade = CascadeType.ALL)
	private List<KnjigaTreninga> knjigatreninga;

	public Operater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
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

	public List<KnjigaTreninga> getKnjigatreninga() {
		return knjigatreninga;
	}

	public void setKnjigatreninga(List<KnjigaTreninga> knjigatreninga) {
		this.knjigatreninga = knjigatreninga;
	}

	@Override
	public String toString() {
		return "Operater [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", password="
				+ password + ", knjigatreninga=" + knjigatreninga + "]";
	}
	
	
}
