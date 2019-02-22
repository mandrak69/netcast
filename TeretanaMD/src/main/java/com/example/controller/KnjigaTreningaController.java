package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ClanDAO;
import com.example.dao.KnjigaTreningaDAO;
import com.example.domain.Clan;
import com.example.domain.KnjigaTreninga;




@RestController    
@RequestMapping(path="/knjiga") 
public class KnjigaTreningaController {
	
	@Autowired      
	private KnjigaTreningaDAO knjigaTreningaDao;

	@PostMapping(path="/add") 
	public @ResponseBody String addNewKnjigaTreninga (@RequestParam String pretplateClanovaId, @RequestParam String treneriId
			, @RequestParam String prezime, @RequestParam String mail,@RequestParam Double cena) {
		
		KnjigaTreninga n = new KnjigaTreninga();
		n.setCena(cena);
		
	    n.setPretplateClanovaId(pretplateClanovaId);
		n.setDatum(datum);
		n.setTreneriId(treneriId);
		knjigaTreningaDao.save(n);

		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<KnjigaTreninga> getAllClan() {
		
		return knjigaTreningaDao.findAll();
	}
}
