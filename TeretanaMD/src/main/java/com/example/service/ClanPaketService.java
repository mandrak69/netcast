package com.example.service;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.example.dao.ClanPaketDAO;

import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.Paket;
import com.example.dto.ClanDTO;
import com.example.dto.ClanPaketDTO;
import com.example.dto.PaketDTO;



@Service
public class ClanPaketService {
	
	
	@Autowired
	ClanPaketDAO clanPaketDao;
	@Autowired
	ClanService clanService;
	@Autowired
	PaketService paketService;

	
	
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
	
	public void deleteById(Long  id) {
		clanPaketDao.deleteById(id);

	}
	public ResponseEntity<Object> create(ClanPaket clanPaket) {
		ClanPaket savedClanPaket = clanPaketDao.save(clanPaket);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedClanPaket.getId()).toUri();

		return ResponseEntity.created(location).build();
		}
	
		
	public ResponseEntity<Object> update( ClanPaketDTO clanPaketdto) {

		Optional<ClanPaket> clp = clanPaketDao.findById(clanPaketdto.getId());

		if (!clp.isPresent())
		{
			return ResponseEntity.notFound().build();
			
		}  else 
		{
		//dohvati sva polja objekta i prepisi u Entity
	    ClanPaket clanPaket = clp.get();
		utility.prekopiraj(clanPaketdto,clanPaket);
		
		clanPaketDao.save(clanPaket);

		return ResponseEntity.noContent().build();
		}
		
	}

	
	public void save(ClanDTO clanDto, PaketDTO paketDto) {
		
	
	    Optional<Clan> cl = clanService.clanDao.findById(clanDto.getId()) ;
	    
	    Optional<Paket> pl = paketService.paketDAO.findById(paketDto.getId());
	    ClanPaket clpl = new ClanPaket();
	    clpl.setClan(cl.get());
	    clpl.setPaket(pl.get());
		clanPaketDao.save(clpl);
		
		
	}

	public Object create(ClanDTO clanDto, PaketDTO paketDto) {

	    Optional<Clan> cl = clanService.clanDao.findById(clanDto.getId()) ;
	    
	    Optional<Paket> pl = paketService.paketDAO.findById(paketDto.getId());
	    ClanPaket clpl = new ClanPaket();
	    clpl.setClan(cl.get());
	    clpl.setPaket(pl.get());
		clanPaketDao.save(clpl);
		return null;
	}



	public void aktiviraj(Long id) {
		// dohvati clanpaket.id aktiviraj paket , dohvati trajanje u minutama

		 // long sad = System.currentTimeMillis();
		  Date pp = new java.util.Date();
		  Instant instant = pp.toInstant();
		  
		 //1 sat =3600*1000milisec. ovde vreme u minutama cuvamo
		 //String output = instantHourLater.toString();
		  
		 Integer istice = clanPaketDao.findById(id).get().getPaket().getTrajanje();
		 Duration duration = Duration.ofMinutes(istice)  ;
		 Instant kasnije = instant.plus( duration );
		 Date enddat = Date.from(kasnije);
		clanPaketDao.findById(id).get().setIstice(enddat);
		// mozda vratiti poruku aktivirano
	}
	 public Collection<ClanPaket> findAllClanPaket(){
			
			List<ClanPaket> spisak = new ArrayList<>();
			for(ClanPaket cc: clanPaketDao.findAll()) {
				spisak.add(cc);
			}
			return spisak;
		}
	
}
