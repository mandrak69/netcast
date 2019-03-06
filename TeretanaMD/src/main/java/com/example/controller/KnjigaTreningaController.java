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
@RequestMapping(path = "/knjiga")
public class KnjigaTreningaController {

	@Autowired
	private KnjigaTreningaDAO knjigaTreningaDao;
	@Autowired
	private ClanPaketDAO clanPaketDao;
	@Autowired
	private TrenerDAO trenerDao;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewKnjigaTreninga(@RequestParam Long trenerId, @RequestParam Long clanPaketId,
			@RequestParam Double cena) {

		KnjigaTreninga n = new KnjigaTreninga();
		n.setCena(cena);
		Optional<ClanPaket> pak = clanPaketDao.findById(clanPaketId);
		
		pak.ifPresent((ph) -> n.setClanPaket(ph));
		Optional<Trener> tre = trenerDao.findById(trenerId);
		tre.ifPresent((ph) -> n.setTrener(ph));
		

		knjigaTreningaDao.save(n);

		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<KnjigaTreninga> getAllClan() {

		return knjigaTreningaDao.findAll();
	}

	@GetMapping(path = "/getId/{id}")
	public @ResponseBody Optional<KnjigaTreninga> getKnjigaTreningabyId(@RequestParam Long id) {
		// JSON clanovi
		return knjigaTreningaDao.findById(id);
	}
	
	//  prebroji broj treninga odradjenih od strane trenera po id
	@PostMapping("/prebroj")
	public long prebroj(@RequestParam Long id) {
		//Long id_tren = trener.getId();
		Optional<Trener> tren = trenerDao.findById(id);
		if (tren.isPresent()) {
		return knjigaTreningaDao.countByTrener(tren.get());
		}
		return 0;
	}
	
//  prebroji broj treninga odradjenih od strane trenera po id
	@PostMapping("/setujNivoTrenera")
	public long setujNivoTrenera(@RequestParam Long id) {
		//Long id_tren = trener.getId();
		Optional<Trener> ima_tren = trenerDao.findById(id);
		if (ima_tren.isPresent()) {
			Trener tren = ima_tren.get();
			long novi_nivo = knjigaTreningaDao.countByTrener(tren)/10;
			tren.setNivo(novi_nivo);
			trenerDao.save(tren);	
		return novi_nivo;
		}
		return 0;
	}
	

}
