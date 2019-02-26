package com.example.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ClanPaketDAO;
import com.example.dao.KnjigatreningaDAO;
import com.example.dao.TrenerDAO;
import com.example.domain.ClanPaket;
import com.example.domain.Knjigatreninga;
import com.example.domain.Trener;




@RestController    
@RequestMapping(path="/knjiga") 
public class KnjigatreningaController {
	
	@Autowired      
	private KnjigatreningaDAO knjigatreningaDao;
    @Autowired
    private ClanPaketDAO clanPaketDao;
    @Autowired
	private TrenerDAO trenerDao;

	@PostMapping(path="/add") 
	public @ResponseBody String addNewKnjigatreninga (@RequestParam Long clanPaketId, @RequestParam Long trenerId
			,@RequestParam Double cena) {
		
    Knjigatreninga n = new Knjigatreninga();
	n.setCena(cena);
	Optional<ClanPaket> pak = clanPaketDao.findById(clanPaketId);
	pak.ifPresent((ph)->n.setClanPaket(ph));
	Optional<Trener> tre = trenerDao.findById(trenerId);
	tre.ifPresent((ph)->n.setTrener(ph));
	 
		knjigatreningaDao.save(n);

		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Knjigatreninga> getAllClan() {
		
		return knjigatreningaDao.findAll();
	}
	@GetMapping(path="/getId/{id}")
	public @ResponseBody Optional<Knjigatreninga> getKnjigatreningabyId(@RequestParam Long id) {
    //  JSON clanovi
    return knjigatreningaDao.findById(id);
}
}
