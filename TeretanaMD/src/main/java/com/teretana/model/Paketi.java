package com.teretana.model;

import java.sql.Date;
import javax.persistence.Entity;


public class Paketi {
	
	private Long id;
	private String ime;
	private Date trajanje;
	private Double cena;
	
	
	private Paketi() {
		
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
	public Date getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(Date trajanje) {
		this.trajanje = trajanje;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	@Override
	public String toString() {
		return "Paketi [id=" + id + ", ime=" + ime + ", trajanje=" + trajanje + ", cena=" + cena + "]";
	}
	
	

}
