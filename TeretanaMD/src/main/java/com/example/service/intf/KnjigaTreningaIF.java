package com.example.service.intf;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.domain.Clan;
import com.example.domain.KnjigaTreninga;
import com.example.dto.KnjigaTreningaClanaDTO;
import com.example.dto.KnjigaTreningaDTO;


public interface KnjigaTreningaIF {

	public KnjigaTreningaDTO save(KnjigaTreningaDTO knjigaTreningadto );
	
	public KnjigaTreningaDTO findById(Long id) ;
	
	public void delete(Long  id);
	
	public KnjigaTreningaDTO addNewWithOperater(KnjigaTreningaDTO knjigaTreningadto,HttpServletRequest httpre );
	
	public KnjigaTreningaDTO update(KnjigaTreningaDTO knjigaTreningadto);
	
	public List<KnjigaTreningaClanaDTO> findByClan(long clan_id);
	public List<KnjigaTreningaClanaDTO> findByClan(long id,long cl);
	public Page<KnjigaTreningaDTO> findAll(Pageable pageable);
}
