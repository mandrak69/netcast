package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ClanDAO;
import com.example.domain.Clan;




@RestController    
@RequestMapping(path="/clan") 
public class ClanController {
	
	@Autowired      
	private ClanDAO clanDao;

	@GetMapping(path="/add") 
	public @ResponseBody String addNewClan ( @RequestParam String ime
			, @RequestParam String prezime, @RequestParam String mail) {
		
		Clan n = new Clan();
		n.setIme(ime);
		n.setPrezime(prezime);
		n.setMail(mail);
		clanDao.save(n);

		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Clan> getAllClan() {
		
		return clanDao.findAll();
	}
}
