package com.example.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PretplateClanova {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Clan clanoviId;
	private Paket paketiId;
	private Date vreme;
	
	
	public PretplateClanova() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public Clan getClanoviId() {
		return clanoviId;
	}


	public void setClanoviId(Clan clanoviId) {
		this.clanoviId = clanoviId;
	}


	public Paket getPaketiId() {
		return paketiId;
	}


	public void setPaketId(Paket paketiId) {
		this.paketiId = paketiId;
	}


	public Date getVreme() {
		return vreme;
	}


	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}


	@Override
	public String toString() {
		return "PretplateClanova [id=" + id + ", clanoviId=" + clanoviId + ", paketiId=" + paketiId + ", vreme=" + vreme
				+ "]";
	}


	
    

	
	
	
}
