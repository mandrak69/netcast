package com.example.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dao.ClanDAO;
import com.example.domain.Clan;
import com.example.domain.DTO.ClanDTO;
import com.example.service.intf.ClanIF;



@Service
public class ClanService implements ClanIF {
	@Autowired
	ClanDAO clanDao;
	
	

	public Clan save(Clan clan) {
		
		clanDao.save(clan);
		
	return clan;

	}
	
	
	//  da li ovo ima supline i lose posledice?
	
public Clan saveDTO(ClanDTO clanDto) {
		Class<? extends Clan> clanCast = (new Clan()).getClass();
		
		
	Clan clanC = clanCast.cast(clanDto);
	
	
	
		clanDao.save(clanC);
		
	return clanC;

	}
	
	public Clan findById(Long id) {
		Optional<Clan> oc = clanDao.findById(id);
		Clan clan = oc.get();
		
	  return clan ;
	}
	
	public void delete(Long  id) {
		clanDao.deleteById(id);

	}
	public ResponseEntity<Object> create(Clan clan) {
		Clan savedClan = clanDao.save(clan);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedClan.getId()).toUri();

		return ResponseEntity.created(location).build();
		}
	
		/*  {
		    "name": "Tom",
		    "passportNumber": "Z1234567"
		  }  */
		/*  pri POST metodu odabrati row  tip i JSON/Aplication/json i radi */
	
	
	
	public ResponseEntity<Object> update( Clan clan) {

	/*	Optional<Clan> cl = clanDao.findById(clan.getId());

		if (!cl.isPresent())
			return ResponseEntity.notFound().build();

		clan.setId(id);
	*/
		
		clanDao.save(clan);

		return ResponseEntity.noContent().build();
	}
}
