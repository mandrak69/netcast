package com.example.dto;

import java.util.List;

import com.example.domain.KnjigaTreninga;
import com.example.domain.Trener;



public class TrenerTerminDTO {

	private Trener trener;
	
	private List<KnjigaTreninga> listaTreninga;

	public TrenerTerminDTO() {
		super();
	}

	public TrenerTerminDTO(Trener trener, List<KnjigaTreninga> listaTreninga) {
		super();
		this.trener = trener;
		this.listaTreninga = listaTreninga;
	}

	public Trener getTrener() {
		return trener;
	}

	public void setTrener(Trener trener) {
		this.trener = trener;
	}

	public List<KnjigaTreninga> getListaTreninga() {
		return listaTreninga;
	}

	public void setListaTreninga(List<KnjigaTreninga> listaTreninga) {
		this.listaTreninga = listaTreninga;
	}

	@Override
	public String toString() {
		return "Termini trenera [trener=" + trener + ", listaTreninga=" + listaTreninga + "]";
	}


	
	
}
