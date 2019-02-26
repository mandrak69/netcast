package com.example.domain.DTO;

import com.example.domain.Clan;
import com.example.domain.Paket;

public class ClanPaketDTO {
	
	private Long id;
    private Clan clan;
    private Paket paket;
    
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

   
}
