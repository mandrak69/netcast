package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.dao.KnjigaTreningaDAO;

import com.example.domain.KnjigaTreninga;
import com.example.domain.Operater;
import com.example.dto.KnjigaTreningaDTO;



@Service
public class KnjigaTreningaService {
	@Autowired
	KnjigaTreningaDAO knjigaTreningaDao;
	
	

	public KnjigaTreninga save(KnjigaTreninga knjigaTreninga) {
		
		knjigaTreningaDao.save(knjigaTreninga);
		
	return knjigaTreninga;

	}
	
	public KnjigaTreninga findById(Long id) {
		Optional<KnjigaTreninga> oc = knjigaTreningaDao.findById(id);
		KnjigaTreninga knjigaTreninga = oc.get();
		
	  return knjigaTreninga ;
	}
	
	public void delete(Long  id) {
		knjigaTreningaDao.deleteById(id);

	}
	
		
	public ResponseEntity<Object> update( KnjigaTreningaDTO knjigaTreningadto) {

		Optional<KnjigaTreninga> clp = knjigaTreningaDao.findById(knjigaTreningadto.getId());

		if (!clp.isPresent())
		{
			return ResponseEntity.notFound().build();
			
		}  else 
		{
		//dohvati sva polja objekta i prepisi u Entity
			KnjigaTreninga knj = clp.get();
		MyUtil.prekopiraj(knjigaTreningadto,knj);
		
		knjigaTreningaDao.save(knj);

		return ResponseEntity.noContent().build();
		}
		
	}
	public List<KnjigaTreninga> findByOperater(Operater operater) {
		
		 List<KnjigaTreninga> oc = knjigaTreningaDao.findByOperater(operater);
		
		
	  return oc ;
	}
	
	
	
	
}
