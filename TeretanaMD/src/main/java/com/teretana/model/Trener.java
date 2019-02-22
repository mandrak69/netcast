package com.teretana.model;


import javax.persistence.Entity;

@Entity
public class Trener {

	
	private Long id;

	private String ime;
	
    private String prezime;
	
	private double cena;

	private Trener() {
		
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

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Trener [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", cena=" + cena + "]";
	}

	
	
	
	
   
	
	
	}
