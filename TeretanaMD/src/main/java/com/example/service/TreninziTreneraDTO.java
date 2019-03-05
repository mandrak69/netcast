package com.example.service;

import java.util.Date;


import com.example.domain.ClanPaket;


public class TreninziTreneraDTO {
	     private Date vreme;
	    private Double cena;
	    private Date vremedo;

	    private ClanPaket clanPaket;

		public TreninziTreneraDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Date getVreme() {
			return vreme;
		}

		public void setVreme(Date vreme) {
			this.vreme = vreme;
		}

		public Double getCena() {
			return cena;
		}

		public void setCena(Double cena) {
			this.cena = cena;
		}

		public Date getVremedo() {
			return vremedo;
		}

		public void setVremedo(Date vremedo) {
			this.vremedo = vremedo;
		}

		public ClanPaket getClanPaket() {
			return clanPaket;
		}

		public void setClanPaket(ClanPaket clanPaket) {
			this.clanPaket = clanPaket;
		}

	    
}
