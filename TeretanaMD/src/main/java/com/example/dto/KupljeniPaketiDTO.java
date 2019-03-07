package com.example.dto;

import java.util.List;


//import com.example.domain.ClanPaket;
import com.example.domain.Paket;

public class KupljeniPaketiDTO {

    private Long id; 
    private Long tickettId;
    private String ticketName;  
    private Double ticketPrice;
    private Integer ticketExp;
    
    
    
	public KupljeniPaketiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getTickettId() {
		return tickettId;
	}



	public void setTickettId(Long tickettId) {
		this.tickettId = tickettId;
	}



	public String getTicketName() {
		return ticketName;
	}



	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}



	public Double getTicketPrice() {
		return ticketPrice;
	}



	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}



	public Integer getTicketExp() {
		return ticketExp;
	}



	public void setTicketExp(Integer ticketExp) {
		this.ticketExp = ticketExp;
	}



	@Override
	public String toString() {
		return "Ticket [id=" + id + ", tickettId=" + tickettId + ", ticketName=" + ticketName
				+ ", ticketPrice=" + ticketPrice + ", ticketExp=" + ticketExp + "]";
	}



	
    
}
