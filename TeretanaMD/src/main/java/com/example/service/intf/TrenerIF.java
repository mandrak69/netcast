package com.example.service.intf;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.domain.Trener;

import com.example.dto.TrenerDTO;
import com.example.dto.TrenerTerminDTO;


public interface TrenerIF {

	public List<Trener> findAll();
	
	public TrenerDTO save( TrenerDTO trenerdto);
	
	public void delete( Long trenerId);
	
	public TrenerDTO update(TrenerDTO trenerdto);
	
	public TrenerTerminDTO listtreninga(Long id);
	public Trener findById(Long id) ;
	public Page<Trener> findAll(Pageable pageable);
}
