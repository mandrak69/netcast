package com.example.service.intf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.example.domain.Paket;
import com.example.dto.PaketDTO;


public interface PaketIF {
	
	
	
	public PaketDTO save(PaketDTO paketdto);
	
	public Paket findById(Long id) ;
	
	public void delete(Long  id);
	
	
	
	public PaketDTO update(PaketDTO paket);
	
	

	public Page<Paket> findAll(Pageable pageable);
}
