package com.example.dto;

public class GrupaDTO {
	
    private Long id; 
    private String ime;  
    private int popust;
    
    
	public GrupaDTO() {
		super();
		// TODO Auto-generated constructor stub
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


	@Override
	public String toString() {
		return "GrupaDTO [id=" + id + ", ime=" + ime + ", popust=" + popust + "]";
	}


    
    
}
