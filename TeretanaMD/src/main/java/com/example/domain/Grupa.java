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
public class Grupa  {
    
 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
   
    private int popust;
  
    
   
    @OneToMany(mappedBy = "grupa", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Clan> clanovi = new HashSet<>();

    public Grupa() {
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

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}

	public Set<Clan> getClanovi() {
		return clanovi;
	}

	public void setClanovi(Set<Clan> clanovi) {
		this.clanovi = clanovi;
	}
	
	

	@Override
	public String toString() {
		return "Grupa [id=" + id + ", ime=" + ime + ", popust=" + popust + ", clanovi=" + clanovi + "]";
	}

    
}

