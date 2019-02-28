package com.example.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Clan;
import com.example.dto.ClanDTO;
import com.example.service.ClanService;


@RestController    
@RequestMapping(path="/clan") 
public class ClanController {
	
	
	@Autowired
	private ClanService clanService;
	
	public ClanController() {
		super();	
	}
	
	@GetMapping(path="/all")
	   public @ResponseBody Collection<Clan> getAllClan() {
		Collection<Clan> kk = clanService.findClans();
	 	 // vraca JSON format clanove 
	   return kk;
	}
	
	@PostMapping(path="/add") 
	public @ResponseBody ClanDTO addNewClan (@RequestBody ClanDTO clandto) {
		
		 ClanDTO cc = clanService.saves(clandto);
		
	return cc;
	}
	
	@GetMapping(path="/get/{id}")
	public @ResponseBody Clan getClanbyId(@PathVariable Long id)  {				
    return clanService.findById(id);
    
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createClan(@RequestBody ClanDTO clandto) {
		
		
		return  ResponseEntity.ok().body(clanService.create(clandto));
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {	
		clanService.delete(id);		
	}	
	
	//  nema logike vec je za probu
	@DeleteMapping("/{clanId}")
	public void deleteClan(@PathVariable String clanId,@RequestBody Clan clan) {
			
		clanService.delete(clan.getId());		
	}	
	
	/*  izmena postojeceg clana preko ID uz optional<> -- mozda pukne*/
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateClan(@PathVariable("id") Long id,@RequestBody ClanDTO clandto) {

		ResponseEntity<Object> t = clanService.update(id,clandto);

		return t;
	}
	
	
	
}
