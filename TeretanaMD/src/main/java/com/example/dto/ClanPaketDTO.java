package com.example.dto;

import java.util.Date;

import com.example.domain.Clan;
import com.example.domain.Paket;

public class ClanPaketDTO {
	
	private Long id;
    private Clan clan;
    private Paket paket;
    private Date datum;
    private Date istice;
    
    
	public ClanPaketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
	public Paket getPaket() {
		return paket;
	}
	public void setPaket(Paket paket) {
		this.paket = paket;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Date getIstice() {
		return istice;
	}
	public void setIstice(Date istice) {
		this.istice = istice;
	}

   
}
