package com.example.dto;

import java.util.Date;

import com.example.domain.Clan;
import com.example.domain.Paket;

public class ClanKupioPaketDTO {
	
	private Long id;
    private long clanId;
    private long paketId;
    private Date datum;
    private Date istice;
    
    
	public ClanKupioPaketDTO() {
		super();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public long getClanId() {
		return clanId;
	}
	public void setClanId(long clanId) {
		this.clanId = clanId;
	}
	public long getPaketId() {
		return paketId;
	}
	public void setPaketId(long paketId) {
		this.paketId = paketId;
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
