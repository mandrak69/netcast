package com.example.controller;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PaketDAO;
import com.example.domain.Knjigatreninga;
import com.example.domain.Paket;

@RestController    
@RequestMapping(path="/paket") 
public class PaketController {
	@Autowired 
	          
	private PaketDAO paketDao;

	@GetMapping(path="/add") 
	public @ResponseBody String addNewPaket (@RequestParam String ime
			, @RequestParam Date vreme, @RequestParam Double cena) {
		
		Paket n = new Paket();
		n.setIme(ime);
		n.setVreme(vreme);
		n.setCena(cena);
		paketDao.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Paket> getAllPaket() {
		
		return paketDao.findAll();
	}
	@GetMapping(path="/getId/{id}")
	public @ResponseBody Optional<Paket> getPaketbyId(@RequestParam Long id) {
    //  JSON clanovi
    return paketDao.findById(id);
}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deletePaket(@PathVariable("id") Long id) {
		paketDao.deleteById(id);		
	}
}
