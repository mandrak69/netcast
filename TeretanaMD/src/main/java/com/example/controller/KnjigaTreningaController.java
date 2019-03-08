package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TeretanaMdApplication;
import com.example.dao.ClanPaketDAO;
import com.example.dao.KnjigaTreningaDAO;
import com.example.dao.OperaterDAO;
import com.example.dao.TrenerDAO;
import com.example.domain.ClanPaket;
import com.example.domain.KnjigaTreninga;
import com.example.domain.Operater;
import com.example.domain.Trener;
import com.example.dto.KnjigaTreningIzvestajDTO;
import com.example.dto.KnjigaTreningaClanaDTO;
import com.example.dto.KnjigaTreningaDTO;
import com.example.security.LoginService;
import com.example.service.intf.KnjigaTreningaIF;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/trainingBook")
public class KnjigaTreningaController {

	@Autowired
	private KnjigaTreningaDAO knjigaTreningaDao;
	
	@Autowired
	private TrenerDAO trenerDao;
	@Autowired
	OperaterDAO operaterDao;
	@Autowired
	KnjigaTreningaIF knjigaTreningaIF;
	@Autowired
	LoginService loginService;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewKnjigaTreninga(@Valid @RequestBody KnjigaTreningIzvestajDTO
			knjigaTreningIzvestajDTO,HttpServletRequest httpre) {
		
		 String uspeh = knjigaTreningaIF.addNewWithOperater(knjigaTreningIzvestajDTO,httpre);
		return uspeh;
	}

	

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<KnjigaTreninga> getAllClan() {

		return knjigaTreningaDao.findAll();
	}

	@GetMapping(path = "/getById/{id}")
	public @ResponseBody Optional<KnjigaTreninga> getKnjigaTreningabyId(@Valid @RequestBody @PathVariable long id) {
		// JSON clanovi
		return knjigaTreningaDao.findById(id);
	}

	// prebroji broj treninga odradjenih od strane trenera po id
	@GetMapping("/countByTrener/{id}")
	public long prebroj(@RequestParam Long id) {
		// Long id_tren = trener.getId();
		Optional<Trener> tren = trenerDao.findById(id);
		if (tren.isPresent()) {
			return knjigaTreningaDao.countByTrener(tren.get());
		}
		return 0;
	}

//  prebroji broj treninga odradjenih od strane trenera po id
	@PostMapping("/setTrenerLevel")
	public long setujNivoTrene(@RequestParam Long id) {
		long novi = knjigaTreningaIF.setujNivoTrenera(id);
		return novi;
	}

	@GetMapping(path = "/memberActivity/{id}")
	public @ResponseBody List<KnjigaTreningaClanaDTO> getTreningForClanId(@Valid @RequestBody @PathVariable long id) {
		// JSON clanovi
		return knjigaTreningaIF.findByClan(id);
	}

	@GetMapping(path = "/between/{id}")
	public @ResponseBody List<KnjigaTreningaClanaDTO> getTreningClanBetw(@Valid @RequestBody @PathVariable long id)
			throws ParseException {
		List<KnjigaTreningaClanaDTO> lista = knjigaTreningaIF.getTreningClanBetween(id);
		return lista;
	}
	
	@GetMapping(path = "/money/{id}")
	public @ResponseBody HashMap<Long, Double> getObracunClan(@Valid @RequestBody @PathVariable long id)
			throws ParseException {
		HashMap<Long, Double> lista =  knjigaTreningaIF.getObracunClanBetween(id);
		return lista;
	}
}
