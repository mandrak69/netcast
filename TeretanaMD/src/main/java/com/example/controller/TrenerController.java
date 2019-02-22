package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.TrenerDAO;
import com.example.domain.Trener;




@RestController    
@RequestMapping(path="/clan") 
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
}
