package com.example.domain;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Entity
public class ClanPaket   {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    
    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Clan clan;

    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Paket paket;

    private Date datum;
    private Date istice;
    @JsonManagedReference
    @OneToMany(mappedBy = "clanPaket", cascade = CascadeType.ALL)
    private Set<KnjigaTreninga> knjigaTreninga=new  HashSet<>();
       
    public ClanPaket() {
		super();
	}

	public ClanPaket(Paket paket, Date datum) {
        this.paket = paket;
        this.datum = datum;
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

	


	public Set<KnjigaTreninga> getKnjigaTreninga() {
		return knjigaTreninga;
	}

	public void setKnjigaTreninga(Set<KnjigaTreninga> knjigaTreninga) {
		this.knjigaTreninga = knjigaTreninga;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClanPaket)) return false;
        ClanPaket that = (ClanPaket) o;
        return Objects.equals(clan.getIme(), that.clan.getIme()) &&
                Objects.equals(paket.getIme(), that.paket.getIme()) &&
                Objects.equals(datum, that.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clan.getIme(), paket.getIme(), datum);
    }
    
}
