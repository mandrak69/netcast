package com.example.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class KnjigaTreninga   {
    
 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //vremeod  i vremedo supredvidjena za prijavu i odjavu sa treninga
    private Date vreme;
    private Double cena;
    private Date vremedo;
    
    @ManyToOne(optional = true)
    @JoinColumn
    @JsonBackReference
    private Trener trener;

    @ManyToOne(optional = false)
    @JoinColumn
    @JsonBackReference
    private ClanPaket clanPaket;
    
    
    @ManyToOne(optional = false)
    @JoinColumn
    @JsonBackReference
    private Operater operater;
    
    
    public KnjigaTreninga() {
    }

    public KnjigaTreninga(Date vreme, Double cena, Trener trener, ClanPaket clanPaket,Operater operater) {
        this.vreme = vreme;
        this.cena = cena;
        this.trener = trener;
        this.clanPaket = clanPaket;
        this.operater=operater;
    }

    public Long getId() {
        return id;
    }

    public Operater getOperater() {
		return operater;
	}

	public void setOperater(Operater operater) {
		this.operater = operater;
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
        if (!(object instanceof KnjigaTreninga)) {
            return false;
        }
        KnjigaTreninga other = (KnjigaTreninga) object;
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

}
