package com.example.controller;

import java.util.Collection;
import java.util.Date;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
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

import com.example.domain.ClanPaket;

import com.example.dto.ClanDTO;
import com.example.dto.ClanKupioPaketDTO;
import com.example.dto.ClanPaketDTO;
import com.example.dto.PaketDTO;
import com.example.service.ClanPaketService;
import com.example.service.MyUtil;
//import org.jsondoc.core.annotation.ApiFlow;
//import org.jsondoc.core.annotation.ApiFlowSet;
//import org.jsondoc.core.annotation.ApiFlowStep;

@RestController
@RequestMapping(path = "/tickets")
@Api(description = "The Member's tickets controller", name = "Member's ticketing services")

public class ClanPaketController {

	@Autowired
	private ClanPaketService clanPaketService;

	public ClanPaketController() {
		super();

	}

	@ApiMethod
	@GetMapping
	public @ResponseBody Collection<ClanPaket> getAllClanPaket() {
		Collection<ClanPaket> clanoviIpaketi = clanPaketService.findAllClanPaket();
		
		return clanoviIpaketi;
	}

	@ApiMethod
	@GetMapping(path = "/all")
	public @ResponseBody Collection<ClanPaket> getAllSoldTickets() {
		Collection<ClanPaket> clanoviIpaketi = clanPaketService.findAllClanPaket();
		
		return clanoviIpaketi;
	}

	@ApiMethod
	@PostMapping(path = "/add")
	public @ResponseBody String addNewClanPaket(@RequestBody ClanKupioPaketDTO clanKupioPaketDTO) {

		clanPaketService.kupljenPaket(clanKupioPaketDTO);

		return "Saved";
	}


	@GetMapping(path = "/acivate/{id}")
	public void aktivirajPaket(@PathVariable Long id) {
		clanPaketService.aktiviraj(id);
		return;
	}

	@GetMapping(path = "/getById/{id}")
	public @ResponseBody ClanPaket getClanPaketbyId(@PathVariable Long id) {
		return clanPaketService.findById(id);

	}

	@PostMapping(path = "/get")
	public @ResponseBody ClanPaketDTO getClanPaket(@RequestBody ClanPaketDTO clanPaketDto) {
		
		ClanPaket cln = clanPaketService.findById(clanPaketDto.getId());
		MyUtil.prekopiraj(cln, clanPaketDto);
		return clanPaketDto;
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@RequestBody ClanPaketDTO clanPaketDto) {
		ClanPaket cln = clanPaketService.findById(clanPaketDto.getId());

		clanPaketService.deleteById(cln.getId());
	}

	@PutMapping("/update")
	public ClanPaketDTO updateClanPaket(@RequestBody ClanPaketDTO clanPaketDto) {

		ClanPaketDTO clp_temp = clanPaketService.update(clanPaketDto);

		return clp_temp;
	}

}
