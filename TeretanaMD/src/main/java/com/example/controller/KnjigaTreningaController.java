package com.example.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.example.dto.KnjigaTreningaClanaDTO;
import com.example.dto.KnjigaTreningaDTO;
import com.example.service.intf.KnjigaTreningaIF;

@RestController
@RequestMapping(path = "/knjiga")
public class KnjigaTreningaController {

	@Autowired
	private KnjigaTreningaDAO knjigaTreningaDao;
	@Autowired
	private ClanPaketDAO clanPaketDao;
	@Autowired
	private TrenerDAO trenerDao;

	@Autowired
	KnjigaTreningaIF knjigaTreningaIF;
	
	
	@PostMapping(path = "/add")
	public @ResponseBody String addNewKnjigaTreninga(@Valid @RequestBody @PathVariable long trenerId, @RequestParam long clanPaketId,
			@RequestParam Double cena) {

		KnjigaTreninga novi_trening = new KnjigaTreninga();
		novi_trening.setCena(cena);
		Optional<ClanPaket> pak = clanPaketDao.findById(clanPaketId);
		
		pak.ifPresent((ph) -> novi_trening.setClanPaket(ph));
		Optional<Trener> tre = trenerDao.findById(trenerId);
		tre.ifPresent((ph) -> novi_trening.setTrener(ph));
		

		knjigaTreningaDao.save(novi_trening);

		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<KnjigaTreninga> getAllClan() {

		return knjigaTreningaDao.findAll();
	}

	@GetMapping(path = "/getId/{id}")
	public @ResponseBody Optional<KnjigaTreninga> getKnjigaTreningabyId(@Valid @RequestBody @PathVariable long id) {
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
	
	@GetMapping(path = "/getbyClanId/{id}")
	public @ResponseBody List<KnjigaTreningaClanaDTO> getTreningForClanId(@Valid @RequestBody @PathVariable long id) {
		// JSON clanovi
		return knjigaTreningaIF.findByClan(id);
	}
	
	@GetMapping(path = "/between/{id}")
	public @ResponseBody List<KnjigaTreningaClanaDTO> getTreningClanBetween(@Valid @RequestBody @PathVariable long id) throws ParseException {
		// JSON clanovi
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		
		Calendar startday = Calendar.getInstance();
		startday.set(Calendar.DAY_OF_MONTH, 1);
		Date enddate = new Date();
		
		return knjigaTreningaDao.findByVremeBetween(startday.getTime(),enddate);
	}
	
	
}
