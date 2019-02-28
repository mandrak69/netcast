package com.example.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    
    private String prezime;
    private String pass;
    private String email;

    @OneToMany(mappedBy = "clan", cascade = CascadeType.ALL)
    private Set<ClanPaket> clanPaketi;

    public Clan() {
    }

    
    
    public Clan(String ime, ClanPaket... clanPaketi) {
        this.ime = ime;
        for(ClanPaket clanPaket : clanPaketi) clanPaket.setClan(this);
        this.clanPaketi = Stream.of(clanPaketi).collect(Collectors.toSet());
    }



	public Clan(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
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



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Set<ClanPaket> getClanPaketi() {
		return clanPaketi;
	}



	public void setClanPaketi(Set<ClanPaket> clanPaketi) {
		this.clanPaketi = clanPaketi;
	}
    
}

