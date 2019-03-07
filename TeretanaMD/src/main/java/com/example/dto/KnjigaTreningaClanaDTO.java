package com.example.dto;

import java.util.Date;

import com.example.domain.ClanPaket;
import com.example.domain.Operater;
import com.example.domain.Trener;

public class KnjigaTreningaClanaDTO {

	
	 
    private Long id;
    
    private Date vreme;
    private Double cena;
    private Date vremedo;
      
    private Long trenerId;
    private Long paketId;
   
    
    
    public KnjigaTreningaClanaDTO() {
    }

    public KnjigaTreningaClanaDTO(Date vreme, Double cena, Long trenerId, ClanPaket clanPaket) {
        this.vreme = vreme;
        this.cena = cena;
        this.trenerId = trenerId;
        
        
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

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

   
   

   
	public Long getTrenerId() {
		return trenerId;
	}

	public void setTrenerId(Long trenerId) {
		this.trenerId = trenerId;
	}

	public Long getPaketId() {
		return paketId;
	}

	public void setPaketId(Long paketId) {
		this.paketId = paketId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

   


	public Date getVremedo() {
		return vremedo;
	}

	public void setVremedo(Date vremedo) {
		this.vremedo = vremedo;
	}

	@Override
	public String toString() {
		return "KnjigaTreningaClanaDTO [id=" + id + ", vreme=" + vreme + ", cena=" + cena + ", vremedo=" + vremedo
				+ ", trenerId=" + trenerId + ", paketId=" + paketId + "]";
	}


	

	

	
}
