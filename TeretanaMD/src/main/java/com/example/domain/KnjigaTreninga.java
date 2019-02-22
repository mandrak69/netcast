package com.example.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class KnjigaTreninga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private Trener treneriId;
	private Double cena;
	private PretplateClanova pretplateClanovaId;
	private Date datum;
	
	
	public KnjigaTreninga() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	


	public Double getCena() {
		return cena;
	}


	public void setCena(Double cena) {
		this.cena = cena;
	}


	


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public Trener getTreneriId() {
		return treneriId;
	}


	public void setTreneriId(Trener treneriId) {
		this.treneriId = treneriId;
	}


	public PretplateClanova getPretplateClanovaId() {
		return pretplateClanovaId;
	}


	public void setPretplateClanovaId(PretplateClanova pretplateClanovaId) {
		this.pretplateClanovaId = pretplateClanovaId;
	}


	@Override
	public String toString() {
		return "KnjigaTreninga [id=" + id + ", treneriId=" + treneriId + ", cena=" + cena + ", pretplateClanovaId="
				+ pretplateClanovaId + ", datum=" + datum + "]";
	}


	
	
	

}
