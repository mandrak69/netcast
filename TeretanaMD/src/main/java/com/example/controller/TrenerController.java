package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.TrenerDAO;
import com.example.domain.Trener;
import com.example.dto.TrenerDTO;
import com.example.service.TrenerService;


@RestController    
@RequestMapping(path="/trener") 
public class TrenerController {
	
	    @Autowired
		private TrenerService trenerService;
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
		public @ResponseBody TrenerDTO addNewTrener (@RequestBody TrenerDTO trenerdto) {
			
			trenerService.save(trenerdto);
			return trenerdto;
		}
		
	
		@GetMapping(path="/getId/{id}")
		public @ResponseBody Trener getTrenerbyId(@PathVariable Long id) {
	    //  JSON clanovi
	    return trenerService.findById(id);
		}
		
		
		@PutMapping("/update/{id}")
		public TrenerDTO updatetrener(@RequestBody TrenerDTO trenerDTO) {

			TrenerDTO trener_temp = trenerService.update(trenerDTO);

			return trener_temp;
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteTrener(@PathVariable Long id) {
			trenerDao.deleteById(id);
			
		}		
		
	}

