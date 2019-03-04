package com.example.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Clan;
import com.example.dto.ClanDTO;
import com.example.dto.KupljeniPaketiDTO;
import com.example.service.intf.ClanIF;

@RestController
@RequestMapping(path = "/clan")
public class ClanController {

	@Autowired
	private ClanIF clanService;

	public ClanController() {
		super();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Collection<Clan> getAllClan() {
		List<Clan> spisakClanova = clanService.findAll();

		return spisakClanova;
	}

	@GetMapping("/clanovi")
	public Page<Clan> findAll(Pageable pageable) {
		return clanService.findAll(pageable);
	}

	@PostMapping(path = "/add")
	public @ResponseBody ClanDTO addNewClan(@RequestBody ClanDTO clandto) {

		ClanDTO clanAdd = clanService.save(clandto);

		return clanAdd;
	}

	@GetMapping(path = "/get/{id}")
	public @ResponseBody Clan getClanbyId(@PathVariable Long id) {
		return clanService.findById(id);

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		clanService.delete(id);
	}

	@PutMapping("/update/{id}")
	public ClanDTO updateClan(@PathVariable Long id, @RequestBody ClanDTO clandto) {

		ClanDTO clan_temp = clanService.update(id, clandto);

		return clan_temp;
	}

	@GetMapping(value = "/paketi_clana/{id}")
	public KupljeniPaketiDTO listaPaketaClana(@PathVariable Long id) {
		return clanService.paketiClana(id);
	}

}
