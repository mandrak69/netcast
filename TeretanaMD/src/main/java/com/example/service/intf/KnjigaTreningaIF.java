package com.example.service.intf;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Clan;
import com.example.domain.KnjigaTreninga;
import com.example.dto.KnjigaTreningIzvestajDTO;
import com.example.dto.KnjigaTreningaClanaDTO;
import com.example.dto.KnjigaTreningaDTO;


public interface KnjigaTreningaIF {

	public KnjigaTreningaDTO save(KnjigaTreningaDTO knjigaTreningadto );
	
	public KnjigaTreningaDTO findById(Long id) ;
	
	public void delete(Long  id);
	
	public String addNewWithOperater(KnjigaTreningIzvestajDTO knjigaTreningadto,HttpServletRequest httpre );
	
	public KnjigaTreningaDTO update(KnjigaTreningaDTO knjigaTreningadto);
	
	public List<KnjigaTreningaClanaDTO> findByClan(long clan_id);
	public List<KnjigaTreningaClanaDTO> findByClan(long id,long cl);
	public Page<KnjigaTreningaDTO> findAll(Pageable pageable);
	public List<KnjigaTreningaClanaDTO> getTreningClanBetween(long id);
	public long setujNivoTrenera( Long id);
	
	public HashMap<Long, Double> getObracunClanBetween(long id);
}
