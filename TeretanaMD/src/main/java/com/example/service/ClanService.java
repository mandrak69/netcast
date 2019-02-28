package com.example.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dao.ClanDAO;
import com.example.domain.Clan;
import com.example.dto.ClanDTO;
import com.example.service.intf.ClanIF;




@Service
public class ClanService implements ClanIF {
	
	@Autowired
	ClanDAO clanDao;
	
	
	
	//  da li ovo ima ssupline i lose posledice?
	@Override

	public ClanDTO saves(ClanDTO clandto){
		Clan cl = new Clan();
		BeanUtils.copyProperties(clandto, cl);
			
		clanDao.save(cl);
		BeanUtils.copyProperties(cl, clandto);
		
	return clandto;

	}
	
	@Override

	public Clan findById(Long id) {
		Optional<Clan> oc = clanDao.findById(id);
		Clan clan = oc.get();
		
	  return clan ;
	}
	@Override
	
	public void delete(Long  id) {
		clanDao.deleteById(id);

	}
	@Override
	
	public ResponseEntity<Object> create(ClanDTO clandto) {
		Clan cl = new Clan();
		BeanUtils.copyProperties(cl, clandto);
		Clan savedClan = clanDao.save(cl);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedClan.getId()).toUri();

		return ResponseEntity.created(location).build();
		}
	
		
	
	@Override
	@Transactional
	public ResponseEntity<Object> update( Long id,ClanDTO clandto) {

		Optional<Clan> clp = clanDao.findById(clandto.getId());

		if (!clp.isPresent())
		{
			return ResponseEntity.notFound().build();
			
		}  else 
		{
		//dohvati sva polja objekta i prepisi u Entity
	    Clan clan = clp.get();
		utility.prekopiraj(clandto,clan);
		
		clanDao.save(clan);

		return ResponseEntity.noContent().build();
		}
		
	}
   public Collection<Clan> findClans(){
		
		List<Clan> spisak = new ArrayList<>();
		for(Clan cc: clanDao.findAll()) {
			spisak.add(cc);
		}
		return spisak;
	}

    @Override
    public Page<Clan> findAll(Pageable pageable) {
      //  treba prepakovati u DTO.  
	
	  return clanDao.findAll(pageable);
}

	
}
