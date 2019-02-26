package com.example.service.intf;

import org.springframework.http.ResponseEntity;

import com.example.domain.Clan;
import com.example.domain.DTO.ClanDTO;

public interface ClanIF {
	
	public Clan save(Clan clan);
	
	public Clan saveDTO(ClanDTO clanDto);
	
	public Clan findById(Long id) ;
	
	public void delete(Long  id);
	
	public ResponseEntity<Object> create(Clan clan);
	
	public ResponseEntity<Object> update( Clan clan);
	
}
