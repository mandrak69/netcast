package com.example.controller;

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
import com.example.dao.ClanDAO;
import com.example.domain.Clan;
import com.example.domain.DTO.ClanDTO;
import com.example.service.ClanService;


@RestController    
@RequestMapping(path="/clan") 
public class ClanController {
	
	@Autowired      
	private ClanDAO clanDao;
	@Autowired
	private ClanService clanService;
	
	public ClanController() {
		super();	
	}
	
	@GetMapping(path="/all")
	   public @ResponseBody Iterable<Clan> getAllClan() {
	 	 // vraca JSON format clanove 
	   return clanDao.findAll();
	}
	
	@PostMapping(path="/add") 
	public @ResponseBody Clan addNewClan (@RequestBody Clan clan) {
	
		clanService.save(clan);
	return clan;
	}
	
	//---------------------------------------------------------------------------------------
	//   u POST ide ClanDTO sa imenom,prezimenom,adresom.Zove addNewClanDTO koja pravi Clan objekat i snima 
	@PostMapping(path="/addDTO") 
	public @ResponseBody Clan addNewClanDTO (@RequestBody ClanDTO clanDto) {
	
		Clan clanSaved = clanService.saveDTO(clanDto);
	return clanSaved;
	}
	
	

	// POST metod za dodavanje clana - nije testiran - pojasniti
	
	@PostMapping("/create")
	public ResponseEntity<Object> createClan(@RequestBody Clan clan) {
			
		return  ResponseEntity.ok().body(clanService.create(clan));
	}
	
	@GetMapping(path="/getId/{id}")
	public @ResponseBody Clan getClanbyId(@PathVariable Long id)  {				
    return clanService.findById(id);
    
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {	
		clanService.delete(id);		
	}	
	
	@DeleteMapping("/deleteClan")
	public void deleteClan(@RequestBody Clan clan) {	
		clanService.delete(clan.getId());		
	}	
	
	/*  izmena postojeceg clana preko ID uz optional<> -- mozda pukne*/
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateClan(@PathVariable("id") Long id) {

		ResponseEntity<Object> t = clanService.update(clanDao.findById(id).get());

		return t;
	}
	@PutMapping("/update")
	public ResponseEntity<Object> updateClan(@RequestBody Clan clan) {

		ResponseEntity<Object> t = clanService.update(clan);

		return t;
	}
}
