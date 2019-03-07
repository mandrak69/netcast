package com.example.service.intf;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.domain.Clan;
import com.example.domain.Grupa;
import com.example.dto.ClanDTO;
import com.example.dto.KupljeniPaketiDTO;



public interface ClanIF {
	
	
	public List<Clan> findAll();
	
	public ClanDTO save(ClanDTO clandto);
	
	public Clan findById(Long id) ;
	
	public void delete(Long  id);
	
	public List<KupljeniPaketiDTO> paketiClana(Long id);
	
	public ClanDTO update(Long id, ClanDTO clandto);
	
	public long countByIme(String tenantName) ;

	public Page<Clan> findAll(Pageable pageable);

	public Iterable<Clan> findByGrupa(Grupa findById);
	
	
	
	
}
