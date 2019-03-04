package com.example.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.domain.Grupa;
import com.example.dto.GrupaDTO;
import com.example.service.intf.GrupaIF;



@RestController    
@RequestMapping(path="/grupa") 
public class GrupaController {
	
	
	@Autowired
	private GrupaIF grupaService;
	
	public GrupaController() {
		super();	
	}
	
	@GetMapping(path="/all")
	   public @ResponseBody Collection<Grupa> getAllGrupa() {
		  List<Grupa> spisakgrupa = grupaService.findAll();
	 	 
	   return spisakgrupa;
	}
	
	@RequestMapping("/clanovi")
	public Page<Grupa> findAll(Pageable pageable){
		return grupaService.findAll(pageable);
	}
	
	@PostMapping(path="/add") 
	public @ResponseBody GrupaDTO addNewGrupa (@RequestBody GrupaDTO grupadto) {
		
		 GrupaDTO grupaAdd = grupaService.save(grupadto);
		
	return grupaAdd;
	}
	
	@GetMapping(path="/get/{id}")
	public @ResponseBody Grupa getGrupabyId(@PathVariable Long id)  {				
    return grupaService.findById(id);
    
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {	
		grupaService.delete(id);		
	}	
	
	
	
	@PutMapping("/update/{id}")
	public GrupaDTO updateGrupa(@PathVariable Long id,@RequestBody GrupaDTO grupadto) {

		GrupaDTO grupa_temp = grupaService.update(id,grupadto);

		return grupa_temp;
	}
	
	/*
	@RequestMapping(value="/clanovi_grupe/{id}")
	public ClanoviGrupeDTO listClanGrupa(@PathVariable Long id) {
		return grupaService.clanovigrupe(id);	
	}
	*/
	
	
	
	
}
