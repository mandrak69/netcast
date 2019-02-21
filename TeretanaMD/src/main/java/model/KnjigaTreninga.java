package model;

import java.sql.Date;

public class KnjigaTreninga {
	
	private Long id;
	private Trener trener;
	private Double cena;
	private PretplateClanova pretplateClanova;
	private Date datum;
	
	
	private KnjigaTreninga() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Trener getTrener() {
		return trener;
	}


	public void setTrener(Trener trener) {
		this.trener = trener;
	}


	public Double getCena() {
		return cena;
	}


	public void setCena(Double cena) {
		this.cena = cena;
	}


	public PretplateClanova getPretplateClanova() {
		return pretplateClanova;
	}


	public void setPretplateClanova(PretplateClanova pretplateClanova) {
		this.pretplateClanova = pretplateClanova;
	}


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}


	@Override
	public String toString() {
		return "KnjigaTreninga [id=" + id + ", trener=" + trener + ", cena=" + cena + ", pretplateClanova="
				+ pretplateClanova + ", datum=" + datum + "]";
	}
	
	

}
