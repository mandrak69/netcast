package com.example.service.intf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.example.domain.Paket;
import com.example.dto.PaketDTO;


public interface PaketIF {
	
	
	
	public PaketDTO saves(PaketDTO paketdto);
	
	public Paket findById(Long id) ;
	
	public void delete(Long  id);
	
	public ResponseEntity<Object> create(PaketDTO paket);
	
	public ResponseEntity<Object> update(PaketDTO paket);
	
	

	public Page<Paket> findAll(Pageable pageable);
}
