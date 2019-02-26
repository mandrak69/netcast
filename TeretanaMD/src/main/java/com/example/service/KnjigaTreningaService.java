package com.example.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.dao.KnjigatreningaDAO;
import com.example.domain.Knjigatreninga;



@Service
public class KnjigaTreningaService {
	@Autowired
	KnjigatreningaDAO knjigatreningaDao;
	
	

	public Knjigatreninga save(Knjigatreninga knjigatreninga) {
		
		knjigatreningaDao.save(knjigatreninga);
		
	return knjigatreninga;

	}
	
	public Knjigatreninga findById(Long id) {
		Optional<Knjigatreninga> oc = knjigatreningaDao.findById(id);
		Knjigatreninga knjigatreninga = oc.get();
		
	  return knjigatreninga ;
	}
	
	public void delete(Long  id) {
		knjigatreningaDao.deleteById(id);

	}
	public ResponseEntity<Object> create(Knjigatreninga knjigatreninga) {
		Knjigatreninga savedKnjigatreninga = knjigatreningaDao.save(knjigatreninga);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedKnjigatreninga.getId()).toUri();

		return ResponseEntity.created(location).build();
		}
	
		
	public ResponseEntity<Object> update( Knjigatreninga knjigatreninga) {

	/*	Optional<Knjigatreninga> cl = knjigatreningaDao.findById(knjigatreninga.getId());

		if (!cl.isPresent())
			return ResponseEntity.notFound().build();

		knjigatreninga.setId(id);
	*/
		
		knjigatreningaDao.save(knjigatreninga);

		return ResponseEntity.noContent().build();
	}
}
