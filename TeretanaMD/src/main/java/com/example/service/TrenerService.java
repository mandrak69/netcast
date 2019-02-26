package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.dao.TrenerDAO;
import com.example.domain.Trener;


import java.net.URI;
import java.util.Optional;


public class TrenerService {
	@Autowired
	TrenerDAO trenerDAO;
	

	
	
	

	public Trener save(Trener trener) {
		
		trenerDAO.save(trener);
		
	return trener;

	}
	
	public Trener findById(Long id) {
		Optional<Trener> oc = trenerDAO.findById(id);
		Trener trener = oc.get();
		
	  return trener ;
	}
	
	public void delete(Long  id) {
		trenerDAO.deleteById(id);

	}
	public ResponseEntity<Object> create(Trener trener) {
		Trener savedTrener = trenerDAO.save(trener);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTrener.getId()).toUri();

		return ResponseEntity.created(location).build();
		}
	
		/*  {
		    "name": "Tom",
		    "passportNumber": "Z1234567"
		  }  */
		/*  pri POST metodu odabrati row  tip i JSON/Aplication/json i radi */
	
	
	
	public ResponseEntity<Object> update( Trener trener) {

	/*	Optional<Trener> cl = TrenerDAO.findById(trener.getId());

		if (!cl.isPresent())
			return ResponseEntity.notFound().build();

		trener.setId(id);
	*/
		
		trenerDAO.save(trener);

		return ResponseEntity.noContent().build();
	}
}



