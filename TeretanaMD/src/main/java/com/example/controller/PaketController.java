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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PaketDAO;
import com.example.domain.Paket;
import com.example.service.PaketService;

@RestController    
@RequestMapping(path="/paket") 
public class PaketController {
	@Autowired 
	          
	private PaketDAO paketDao;
	@Autowired
	private PaketService paketService;
	
	
	public PaketController() {
		super();
		
	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Paket> getAllPaket() {
		
		return paketDao.findAll();
	}
	
	
	@PostMapping(path="/add") 
	public @ResponseBody Paket addNewPaket (@RequestBody Paket paket) {
		
		paketService.save(paket);
		return paket;
	}
	@PostMapping("/create")
	public ResponseEntity<Object> createPaket(@RequestBody Paket paket) {
			
		return paketService.create(paket);
	}
	
	
	@GetMapping(path="/getId/{id}")
	public @ResponseBody Paket getPaketbyId(@PathVariable Long id) {
    //  JSON clanovi
    return paketService.findById(id);
	}
	
	
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deletePaket(@PathVariable("id") Long id) {
		paketDao.deleteById(id);		
	}
	
	@DeleteMapping("/deletePaket")
	public void deletePaket(@RequestBody Paket paket) {
	
		paketService.delete(paket.getId());		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updatePaket(@PathVariable("id") Long id) {

		ResponseEntity<Object> t = paketService.update(paketDao.findById(id).get());

		return t;
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updatePaket(@RequestBody Paket paket) {

		ResponseEntity<Object> t = paketService.update(paket);

		return t;
	}
}
