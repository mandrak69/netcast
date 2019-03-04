package com.example.service.intf;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.example.domain.Clan;
import com.example.dto.ClanDTO;
import com.example.dto.KupljeniPaketiDTO;



public interface ClanIF {
	
	
	public List<Clan> findAll();
	
	public ClanDTO save(ClanDTO clandto);
	
	public Clan findById(Long id) ;
	
	public void delete(Long  id);
	
	public KupljeniPaketiDTO paketiClana(Long id);
	
	public ClanDTO update(Long id, ClanDTO clandto);
	
	

	public Page<Clan> findAll(Pageable pageable);
	
	
	
	
}
