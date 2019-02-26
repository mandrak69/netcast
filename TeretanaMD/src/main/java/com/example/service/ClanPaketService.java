package com.example.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dao.ClanDAO;
import com.example.dao.ClanPaketDAO;
import com.example.dao.PaketDAO;
import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.Paket;
import com.example.domain.DTO.ClanDTO;
import com.example.domain.DTO.ClanPaketDTO;
import com.example.domain.DTO.PaketDTO;



@Service
public class ClanPaketService {
	@Autowired
	ClanPaketDAO clanPaketDao;
	@Autowired
	ClanDAO clanDao;
	@Autowired
	PaketDAO paketDao;

	
	
	public ClanPaketService() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public ClanPaket save(ClanPaketDTO clanPaketDto) {
		Optional<ClanPaket> clpak = clanPaketDao.findById(clanPaketDto.getId());
		clanPaketDao.save(clpak.get());
		
	return clpak.get();

	}
	
	public ClanPaket findById(Long id) {
		Optional<ClanPaket> oc = clanPaketDao.findById(id);
		ClanPaket clanPaket = oc.get();
		
	  return clanPaket ;
	}
	
	public void delete(Long  id) {
		clanPaketDao.deleteById(id);

	}
	public ResponseEntity<Object> create(ClanPaket clanPaket) {
		ClanPaket savedClanPaket = clanPaketDao.save(clanPaket);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedClanPaket.getId()).toUri();

		return ResponseEntity.created(location).build();
		}
	
		
	public ResponseEntity<Object> update( ClanPaket clanPaket) {

	/*	Optional<ClanPaket> cl = clanPaketDao.findById(clanPaket.getId());

		if (!cl.isPresent())
			return ResponseEntity.notFound().build();

		clanPaket.setId(id);
	*/
		
		clanPaketDao.save(clanPaket);

		return ResponseEntity.noContent().build();
	}

	public void save(ClanDTO clanDto, PaketDTO paketDto) {
		
	
	    Optional<Clan> cl = clanDao.findById(clanDto.getId()) ;
	    
	    Optional<Paket> pl = paketDao.findById(paketDto.getId());
	    ClanPaket clpl = new ClanPaket();
	    clpl.setClan(cl.get());
	    clpl.setPaket(pl.get());
		clanPaketDao.save(clpl);
		
		
	}

	public Object create(ClanDTO clanDto, PaketDTO paketDto) {

	    Optional<Clan> cl = clanDao.findById(clanDto.getId()) ;
	    
	    Optional<Paket> pl = paketDao.findById(paketDto.getId());
	    ClanPaket clpl = new ClanPaket();
	    clpl.setClan(cl.get());
	    clpl.setPaket(pl.get());
		clanPaketDao.save(clpl);
		return null;
	}

	
}
