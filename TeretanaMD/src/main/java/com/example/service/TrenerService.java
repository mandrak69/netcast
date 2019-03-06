package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.dao.KnjigaTreningaDAO;
import com.example.dao.TrenerDAO;
import com.example.domain.KnjigaTreninga;
import com.example.domain.Trener;
import com.example.dto.TrenerDTO;
import com.example.dto.TrenerTerminDTO;
import com.example.service.intf.TrenerIF;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service

public class TrenerService implements  TrenerIF{
	@Autowired
	TrenerDAO trenerDao;
	
	@Autowired
	KnjigaTreningaDAO knjigatreningaDao;
	
	
	@Override
	@Transactional
	public List<Trener> findAll() {
		
		return trenerDao.findAll();
	}
	
	@Override

	public TrenerDTO save(TrenerDTO clandto){
		Trener cl = new Trener();
		BeanUtils.copyProperties(clandto, cl);
			
		trenerDao.save(cl);
		BeanUtils.copyProperties(cl, clandto);
		
	return clandto;

	}
	
	@Override

	public Trener findById(Long id) {
		Optional<Trener> oc = trenerDao.findById(id);
		Trener clan = oc.get();
		
	  return clan ;
	}
	@Override
	
	public void delete(Long  id) {
		trenerDao.deleteById(id);

	}
	
	
	
	@Override
	@Transactional
	public TrenerDTO update( TrenerDTO trenrdto) {

		Optional<Trener> cl_temp = trenerDao.findById(trenrdto.getId());

		if (!cl_temp.isPresent())
		
			return null;
			
		//dohvati sva polja objekta i prepisi u Entity
		Trener clan = cl_temp.get();
		MyUtil.prekopiraj(trenrdto,clan);
		
		trenerDao.save(clan);
		MyUtil.prekopiraj(clan,trenrdto);

		return trenrdto;
		
		
	}
   public Collection<Trener> findTreners(){
		
		List<Trener> spisak = new ArrayList<>();
		for(Trener cc: trenerDao.findAll()) {
			spisak.add(cc);
		}
		return spisak;
	}


	@Transactional
	public List<KnjigaTreninga> treninziTrenera(Long id) {
		Optional<Trener> tren_temp = trenerDao.findById(id);
		if(tren_temp.isPresent()) {
			Trener trener = tren_temp.get();
			List<KnjigaTreninga> treninzitrenera = knjigatreningaDao.findByTrener(trener);
			
			
			return treninzitrenera;
		}
		return null;
	}

	
	@Override
	public Page<Trener> findAll(Pageable pageable) {
	 //  List<Trener> clanovi=clanDao.getAllClansByName(null);
		return trenerDao.findAll(pageable);
	}

	@Override
	public TrenerTerminDTO listtreninga(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void odredinivoetrenerima() {
		// TODO Auto-generated method stub
	/*	List<Trener> lista = trenerDao.findAll();
		
		for (Trener tre:lista) {
		//	Object brtreninga = knjigatreningaDao.count(tre);
			
			
		}*/
		
	}

	
}



