package com.example.dto;

public class ClanGrupaDTO {
	
    
    private long clanId;  
    private String member;
    private long grupaId;
    private String grupname;
    
    
    
	public ClanGrupaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getClanId() {
		return clanId;
	}

	public void setClanId(long clanId) {
		this.clanId = clanId;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public long getGrupaId() {
		return grupaId;
	}

	public void setGrupaId(long grupaId) {
		this.grupaId = grupaId;
	}

	public String getGrupname() {
		return grupname;
	}

	public void setGrupname(String grupname) {
		this.grupname = grupname;
	}

	@Override
	public String toString() {
		return "ClanGrupaDTO [clanId=" + clanId + ", member=" + member + ", grupaId=" + grupaId + ", grupname="
				+ grupname + "]";
	}

	
	
}