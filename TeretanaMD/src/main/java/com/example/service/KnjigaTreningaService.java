package com.example.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dao.KnjigaTreningaDAO;

import com.example.domain.KnjigaTreninga;

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
	public ResponseEntity<Object> create(KnjigaTreninga knjigaTreninga) {
		KnjigaTreninga savedKnjigaTreninga = knjigaTreningaDao.save(knjigaTreninga);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedKnjigaTreninga.getId()).toUri();

		return ResponseEntity.created(location).build();
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
		utility.prekopiraj(knjigaTreningadto,knj);
		
		knjigaTreningaDao.save(knj);

		return ResponseEntity.noContent().build();
		}
		
	}
}
