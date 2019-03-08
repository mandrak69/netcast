package com.example.dto;

import java.util.Date;


import com.example.domain.ClanPaket;
import com.example.domain.Operater;
import com.example.domain.Trener;



public class KnjigaTreningIzvestajDTO  {

    
    private Long id;
    
    private Date vreme;
    private double cena;
    private Date vremedo;
      
    private long trener;
    private long clanPaket;
    private long operater;
    
    
    public KnjigaTreningIzvestajDTO() {
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

   
    public long getTrener() {
		return trener;
	}

	public void setTrener(long trener) {
		this.trener = trener;
	}

	public long getClanPaket() {
		return clanPaket;
	}

	public void setClanPaket(long clanPaket) {
		this.clanPaket = clanPaket;
	}

	public void setOperater(long operater) {
		this.operater = operater;
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
        if (!(object instanceof KnjigaTreningIzvestajDTO)) {
            return false;
        }
        KnjigaTreningIzvestajDTO other = (KnjigaTreningIzvestajDTO) object;
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

	public long getOperater() {
		return operater;
	}

	

}
