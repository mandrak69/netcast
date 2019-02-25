package com.example.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dao.ClanDAO;
import com.example.domain.Clan;




@RestController    
@RequestMapping(path="/clan") 
public class ClanController {
	
	@Autowired      
	private ClanDAO clanDao;

	@GetMapping(path="/add") 
	public @ResponseBody String addNewClan ( @RequestParam String ime
			, @RequestParam String prezime, @RequestParam String email) {
		
		Clan n = new Clan();
		n.setIme(ime);
		n.setPrezime(prezime);
		n.setEmail(email);
		clanDao.save(n);

		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Clan> getAllClan() {
		// vraca JSON format clanove 
		return clanDao.findAll();
	}
	@GetMapping(path="/getId/{id}")
	public @ResponseBody Clan getClanbyId(@PathVariable Long id)  {
    //  JSON clanovi
		Optional<Clan> cl = clanDao.findById(id);
		if (!cl.isPresent())
			return (null);
		
    return cl.get();
}
	@DeleteMapping("/delete/{id}")
	public void deleteClan(@PathVariable("id") Long id) {
		clanDao.deleteById(id);		
	}	
	
	
	
	
	
	
	// POST metod za dodavanje clana - nije testiran - pojasniti
	@PostMapping("/addclan")
	public ResponseEntity<Object> createClan(@RequestBody Clan clan) {
		Clan savedClan = clanDao.save(clan);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedClan.getId()).toUri();

		return ResponseEntity.created(location).build();
		/*  {
		    "name": "Tom",
		    "passportNumber": "Z1234567"
		  }  */
		/*  pri POST metodu odabrati row  tip i JSON/Aplication/json i radi */
	}
	
	
	/*  izmena postojeceg clana */
	
	@PutMapping("/izmena/{id}")
	public ResponseEntity<Object> updateClan(@RequestBody Clan clan, @PathVariable long id) {

		Optional<Clan> cl = clanDao.findById(id);

		if (!cl.isPresent())
			return ResponseEntity.notFound().build();

		clan.setId(id);
		
		clanDao.save(clan);

		return ResponseEntity.noContent().build();
	}
}
