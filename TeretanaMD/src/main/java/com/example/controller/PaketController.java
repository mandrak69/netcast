package com.example.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PaketDAO;
import com.example.domain.Paket;

@RestController    
@RequestMapping(path="/paket") 
public class PaketController {
	@Autowired 
	          
	private PaketDAO paketDao;

	@GetMapping(path="/add") 
	public @ResponseBody String addNewPaket (@RequestParam String ime
			, @RequestParam Date trajanje, @RequestParam Double cena) {
		
		Paket n = new Paket();
		n.setIme(ime);
		n.setTrajanje(trajanje);
		n.setCena(cena);
		paketDao.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Paket> getAllPaket() {
		
		return paketDao.findAll();
	}
}
