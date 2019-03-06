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


import com.example.dao.GrupaDAO;

import com.example.domain.Grupa;

import com.example.dto.GrupaDTO;
import com.example.service.intf.GrupaIF;



@Service
public class GrupaService implements GrupaIF {
	
	@Autowired
	GrupaDAO grupaDao;
	
	
	
	@Override
	@Transactional
	public List<Grupa> findAll() {
		
		return grupaDao.findAll();
	}
	
	@Override

	public GrupaDTO save(GrupaDTO grupadto){
		Grupa cl = new Grupa();
		BeanUtils.copyProperties(grupadto, cl);
			
		grupaDao.save(cl);
		BeanUtils.copyProperties(cl, grupadto);
		
	return grupadto;

	}
	
	@Override

	public Grupa findById(Long id) {
		Optional<Grupa> oc = grupaDao.findById(id);
		Grupa grupa = oc.get();
		
	  return grupa ;
	}
	@Override
	
	public void delete(Long  id) {
		grupaDao.deleteById(id);

	}
	
	
	
	@Override
	@Transactional
	public GrupaDTO update( Long id,GrupaDTO grupadto) {

		Optional<Grupa> cl_temp = grupaDao.findById(grupadto.getId());

		if (!cl_temp.isPresent())
		
			return null;
			
		//dohvati sva polja objekta i prepisi u Entity
	    Grupa grupa = cl_temp.get();
		MyUtil.prekopiraj(grupadto,grupa);
		
		grupaDao.save(grupa);
		MyUtil.prekopiraj(grupa,grupadto);

		return grupadto;
		
		
	}
   public Collection<Grupa> findGrupas(){
		
		List<Grupa> spisak = new ArrayList<>();
		for(Grupa cc: grupaDao.findAll()) {
			spisak.add(cc);
		}
		return spisak;
	}


/*	@Transactional
	public KupljeniPaketiDTO paketiGrupaa(Long id) {
		Optional<Grupa> grupa_temp = grupaDao.findById(id);
		if(grupa_temp.isPresent()) {
			Grupa grupa = grupa_temp.get();
			List<Clan> paketiGrupaa = clanDao.findByGrupa(grupa);
			
			List<Paket> pakgrupaa=new ArrayList<Paket>();
			paketiGrupaa.forEach((p)->pakgrupaa.add(p.getPaket()));
			
			
			KupljeniPaketiDTO listaPaketa = new KupljeniPaketiDTO();
			listaPaketa.setId(grupa.getId());
			listaPaketa.setIme(grupa.getIme());
			listaPaketa.setPrezime(grupa.getPrezime());
			listaPaketa.setEmail(grupa.getEmail());
			listaPaketa.setPaket( pakgrupaa);
			
			return listaPaketa;
		}
		return null;
	}
*/
	
	@Override
	public Page<Grupa> findAll(Pageable pageable) {
	 //  List<Grupa> grupaovi=grupaDao.getAllGrupasByIme(null);
		return grupaDao.findAll(pageable);
	}

	
}
