package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.TrenerDAO;
import com.example.domain.Trener;




@RestController    
@RequestMapping(path="/trener") 
public class TrenerController {
	
	@Autowired           
	private TrenerDAO trenerDao;

	@GetMapping(path="/add") 
	public @ResponseBody String addNewTrener (@RequestParam String ime
			, @RequestParam String prezime, @RequestParam Double cena) {
		
		Trener n = new Trener();
		n.setIme(ime);
		n.setPrezime(prezime);
		n.setCena(cena);
		trenerDao.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Trener> getAllTrener() {
		
		return trenerDao.findAll();
	}
	@GetMapping(path="/getId/{id}")
	public @ResponseBody Optional<Trener> getTrenerbyId(@PathVariable Long id) {
    //  JSON clanovi
    return trenerDao.findById(id);
}
	
	
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteTrener(@PathVariable("id") Long id) {
		trenerDao.deleteById(id);		
	}
}
