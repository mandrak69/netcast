package com.example.dto;

import java.util.List;


//import com.example.domain.ClanPaket;
import com.example.domain.Paket;

public class KupljeniPaketiDTO {

    private Long id; 
    private String ime;  
    private String prezime;
    private String email;
    private List<Paket> clanPaket;
    
    
    
	public KupljeniPaketiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public KupljeniPaketiDTO(String ime, String prezime, String email, List<Paket> clanPaket) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.clanPaket = clanPaket;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Paket> getPaket() {
		return clanPaket;
	}



	public void setPaket(List<Paket> clanPaket) {
		this.clanPaket = clanPaket;
	}
    
    
    
}
