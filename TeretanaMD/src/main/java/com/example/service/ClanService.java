package com.example.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.dao.ClanDAO;
import com.example.dao.ClanPaketDAO;

import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.Paket;
import com.example.dto.ClanDTO;
import com.example.dto.KupljeniPaketiDTO;
import com.example.service.intf.ClanIF;



@Service
public class ClanService implements ClanIF {
	
	@Autowired
	ClanDAO clanDao;
	@Autowired
	ClanPaketDAO clanPaketDao;
	
	
	@Override
	@Transactional
	public List<Clan> findAll() {
		
		return clanDao.findAll();
	}
	
	@Override

	public ClanDTO save(ClanDTO clandto){
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
	@Transactional
	public ClanDTO update( Long id,ClanDTO clandto) {

		Optional<Clan> cl_temp = clanDao.findById(clandto.getId());

		if (!cl_temp.isPresent())
		
			return null;
			
		//dohvati sva polja objekta i prepisi u Entity
	    Clan clan = cl_temp.get();
		utility.prekopiraj(clandto,clan);
		
		clanDao.save(clan);
		utility.prekopiraj(clan,clandto);

		return clandto;
		
		
	}
   public Collection<Clan> findClans(){
		
		List<Clan> spisak = new ArrayList<>();
		for(Clan cc: clanDao.findAll()) {
			spisak.add(cc);
		}
		return spisak;
	}


	@Transactional
	public KupljeniPaketiDTO paketiClana(Long id) {
		Optional<Clan> clan_temp = clanDao.findById(id);
		if(clan_temp.isPresent()) {
			Clan clan = clan_temp.get();
			List<ClanPaket> paketiClana = clanPaketDao.findByClan(clan);
			
			List<Paket> pakclana=new ArrayList<Paket>();
			paketiClana.forEach((p)->pakclana.add(p.getPaket()));
			
			
			KupljeniPaketiDTO listaPaketa = new KupljeniPaketiDTO();
			listaPaketa.setId(clan.getId());
			listaPaketa.setIme(clan.getIme());
			listaPaketa.setPrezime(clan.getPrezime());
			listaPaketa.setEmail(clan.getEmail());
			listaPaketa.setPaket( pakclana);
			
			return listaPaketa;
		}
		return null;
	}

	
	@Override
	public Page<Clan> findAll(Pageable pageable) {
	 //  List<Clan> clanovi=clanDao.getAllClansByName(null);
		return clanDao.findAll(pageable);
	}

	
}
