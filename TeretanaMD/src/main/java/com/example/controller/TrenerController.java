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

import com.example.dao.TrenerDAO;
import com.example.domain.Trener;
import com.example.service.TrenerService;





@RestController    
@RequestMapping(path="/trener") 
public class TrenerController {
	
	    
		private TrenerService trenerService=new TrenerService();
		@Autowired 
		private TrenerDAO trenerDao;
		
		
	
		
		public TrenerController() {
			super();
			
		}
		
		
		@GetMapping(path="/all")
		public @ResponseBody Iterable<Trener> getAllTrener() {
			
			return trenerDao.findAll();
		}
		
		
		@PostMapping(path="/add") 
		public @ResponseBody Trener addNewTrener (@RequestBody Trener trener) {
			
			trenerService.save(trener);
			return trener;
		}
		@PostMapping("/create")
		public ResponseEntity<Object> createTrener(@RequestBody Trener trener) {
				
			return trenerService.create(trener);
		}
		
		
		@GetMapping(path="/getId/{id}")
		public @ResponseBody Trener getTrenerbyId(@PathVariable Long id) {
	    //  JSON clanovi
	    return trenerService.findById(id);
		}
		
		
		
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
		public void deleteTrener(@PathVariable("id") Long id) {
			trenerDao.deleteById(id);		
		}
		
		@DeleteMapping("/deleteTrener")
		public void deleteTrener(@RequestBody Trener trener) {
		
			trenerService.delete(trener.getId());		
		}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<Object> updateTrener(@PathVariable("id") Long id) {

			ResponseEntity<Object> t = trenerService.update(trenerDao.findById(id).get());

			return t;
		}
		
		@PutMapping("/update")
		public ResponseEntity<Object> updateTrener(@RequestBody Trener trener) {

			ResponseEntity<Object> t = trenerService.update(trener);

			return t;
		}
	}
