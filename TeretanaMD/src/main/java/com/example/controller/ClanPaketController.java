package com.example.controller;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ClanDAO;
import com.example.dao.ClanPaketDAO;
import com.example.dao.PaketDAO;
import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.Paket;




@RestController    
@RequestMapping(path="/clanpaket") 
public class ClanPaketController {
	
	@Autowired      
	private PaketDAO paketDao;
    @Autowired
    private ClanPaketDAO clanPaketDao;
    @Autowired
	private ClanDAO clanDao;

	@PostMapping(path="/add") 
	public @ResponseBody String addNewClanPaket (@RequestParam Long clanId, @RequestParam Long paketId)
	{
		
    ClanPaket n = new ClanPaket();
	
	Optional<Clan> cl = clanDao.findById(clanId);
	cl.ifPresent((ph)->n.setClan(ph));
	
	Optional<Paket> pa = paketDao.findById(paketId);
	pa.ifPresent((ph)->n.setPaket(ph));
	
	
	n.setDatum(new Date());
		clanPaketDao.save(n);

		return "Saved"+n.getId();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<ClanPaket> getAllClanPaket() {
		
		return clanPaketDao.findAll();
	}
	@GetMapping(path="/getId/{id}")
	public @ResponseBody Optional<ClanPaket> getClanPaketbyId(@RequestParam Long id) {
    //  JSON clanovi
    return clanPaketDao.findById(id);
}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteClanPaket(@PathVariable("id") Long id) {
		clanPaketDao.deleteById(id);		
	}
}
