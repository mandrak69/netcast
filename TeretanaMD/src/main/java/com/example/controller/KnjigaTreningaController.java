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
import com.example.dao.KnjigaTreningaDAO;
import com.example.dao.TrenerDAO;
import com.example.domain.ClanPaket;
import com.example.domain.KnjigaTreninga;
import com.example.domain.Trener;




@RestController    
@RequestMapping(path="/knjiga") 
public class KnjigaTreningaController {
	
	@Autowired      
	private KnjigaTreningaDAO knjigaTreningaDao;
    @Autowired
    private ClanPaketDAO clanPaketDao;
    @Autowired
	private TrenerDAO trenerDao;

	@PostMapping(path="/add") 
	public @ResponseBody String addNewKnjigaTreninga ( @RequestParam Long trenerId,@RequestParam Long clanPaketId,@RequestParam Double cena) {
		
    KnjigaTreninga n = new KnjigaTreninga();
	n.setCena(cena);
	Optional<ClanPaket> pak = clanPaketDao.findById(clanPaketId);
	pak.ifPresent((ph)->n.setClanPaket(ph));
	Optional<Trener> tre = trenerDao.findById(trenerId);
	tre.ifPresent((ph)->n.setTrener(ph));
	 
		knjigaTreningaDao.save(n);

		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<KnjigaTreninga> getAllClan() {
		
		return knjigaTreningaDao.findAll();
	}
	@GetMapping(path="/getId/{id}")
	public @ResponseBody Optional<KnjigaTreninga> getKnjigaTreningabyId(@RequestParam Long id) {
    //  JSON clanovi
    return knjigaTreningaDao.findById(id);
}
}
