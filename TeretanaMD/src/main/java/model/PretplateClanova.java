package model;

import java.sql.Date;
import javax.persistence.Entity;

@Entity
public class PretplateClanova {
	private Long id;
	private Clan clan;
	private Paketi paket;
	private Date vreme;
	
	
	private PretplateClanova() {
		super();
	}


	public Clan getClan() {
		return clan;
	}


	public void setClan(Clan clan) {
		this.clan = clan;
	}


	public Paketi getPaket() {
		return paket;
	}


	public void setPaket(Paketi paket) {
		this.paket = paket;
	}


	public Date getVreme() {
		return vreme;
	}


	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}


	@Override
	public String toString() {
		return "PretplateClanova [clan=" + clan + ", paket=" + paket + ", vreme=" + vreme + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
