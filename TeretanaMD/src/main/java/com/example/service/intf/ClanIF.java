package com.example.service.intf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.example.domain.Clan;
import com.example.dto.ClanDTO;


public interface ClanIF {
	
	
	
	public ClanDTO saves(ClanDTO clandto);
	
	public Clan findById(Long id) ;
	
	public void delete(Long  id);
	
	public ResponseEntity<Object> create(ClanDTO clandto);
	
	public ResponseEntity<Object> update(Long id, ClanDTO clandto);
	
	

	public Page<Clan> findAll(Pageable pageable);
	
}
