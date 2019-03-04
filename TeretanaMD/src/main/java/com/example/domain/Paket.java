package com.example.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Entity
public class Paket  {
    
 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
   
    private Double cena;
  
    private Integer trajanje;
   
    @OneToMany(mappedBy = "paket", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ClanPaket> clanPaketi = new HashSet<>();

    public Paket() {
    }

    public Paket(String ime) {
        this.ime = ime;
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

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Integer getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
	}


	public void setVreme(Integer trajanje) {
		this.trajanje = trajanje;
	}

	public Set<ClanPaket> getClanPaketi() {
		return clanPaketi;
	}

	public void setClanPaketi(Set<ClanPaket> clanPaketi) {
		this.clanPaketi = clanPaketi;
	}
    
}

