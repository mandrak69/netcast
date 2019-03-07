package com.example.dto;

import java.util.Date;


import com.example.domain.ClanPaket;
import com.example.domain.Operater;
import com.example.domain.Trener;



public class KnjigaTreningaDTO  {

    
    private Long id;
    
    private Date vreme;
    private Double cena;
    private Date vremedo;
      
    private Trener trener;
    private ClanPaket clanPaket;
    private Operater operater;
    
    
    public KnjigaTreningaDTO() {
    }

    public KnjigaTreningaDTO(Date vreme, Double cena, Trener trener, ClanPaket clanPaket) {
        this.vreme = vreme;
        this.cena = cena;
        this.trener = trener;
        this.clanPaket = clanPaket;
        
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

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public ClanPaket getClanPaket() {
        return clanPaket;
    }

    public void setClanPaket(ClanPaket clanPaket) {
        this.clanPaket = clanPaket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KnjigaTreningaDTO)) {
            return false;
        }
        KnjigaTreningaDTO other = (KnjigaTreningaDTO) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Knjigatreninga[ id=" + id + " ]";
    }

	public Date getVremedo() {
		return vremedo;
	}

	public void setVremedo(Date vremedo) {
		this.vremedo = vremedo;
	}

	public Operater getOperater() {
		return operater;
	}

	public void setOperater(Operater operater) {
		this.operater = operater;
	}

}
