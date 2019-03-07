package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PaketDAO;
import com.example.domain.Paket;

import com.example.dto.PaketDTO;

import com.example.service.intf.PaketIF;

@RestController    
@RequestMapping(path="/paket") 

public class PaketController {
	
	@Autowired          
	private PaketDAO paketDao;
	@Autowired
	private PaketIF paketService;
			
	public PaketController() {
		super();
		
	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Paket> getAllPaket() {
		
		return paketDao.findAll();
	}
	
	
	
	@PostMapping(path="/add") 
	public @ResponseBody PaketDTO addNewPaket (@RequestBody PaketDTO paketdto) {
		
		paketService.save(paketdto);
		return paketdto;
	}
	
	
	
	@GetMapping(path="/getId/{id}")
	public @ResponseBody Paket getPaketbyId(@PathVariable Long id) {
    //  JSON clanovi
    return paketService.findById(id);
	}
	
	
	
	
	@DeleteMapping(value = "/delete/{id}")
	public void deletePaket(@PathVariable Long id) {
		paketDao.deleteById(id);		
	}
	
	@DeleteMapping("/deletePaket")
	public void deletePaket(@RequestBody PaketDTO paketdto) {
	
		paketService.delete(paketdto.getId());		
	}
	
	
	@PutMapping("/update/{id}")
	public PaketDTO updatePaket(@RequestBody PaketDTO paket) {

		 PaketDTO paket_temp = paketService.update(paket);

		return paket_temp;
	}
	
}
