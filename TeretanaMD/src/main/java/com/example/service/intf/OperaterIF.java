package com.example.service.intf;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.example.domain.Operater;

import com.example.dto.OperaterDTO;



public interface OperaterIF {
	
	
	public List<Operater> findAll();
	
	public OperaterDTO save(OperaterDTO clandto);
	
	public Operater findById(Long id) ;
	
	public void delete(Long  id);
	
	
	
	public OperaterDTO update(Long id, OperaterDTO clandto);
	
	

	public Page<Operater> findAll(Pageable pageable);
	
	
	
	
}
