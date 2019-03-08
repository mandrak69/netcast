package com.example.service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ClanDAO;
import com.example.dao.ClanPaketDAO;
import com.example.dao.PaketDAO;
import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.Paket;
import com.example.dto.ClanDTO;
import com.example.dto.ClanKupioPaketDTO;
import com.example.dto.ClanPaketDTO;
import com.example.dto.PaketDTO;

import exception.ResourceNotFoundException;

@Service
public class ClanPaketService {

	@Autowired
	ClanPaketDAO clanPaketDao;
	@Autowired
	ClanService clanService;
	@Autowired
	PaketService paketService;
	@Autowired
	ClanDAO clanDao;
	@Autowired
	PaketDAO paketDao;

	public ClanPaketService() {
		super();

	}

	public ClanPaket save(ClanPaketDTO clanPaketDto) {

		Optional<ClanPaket> clpak = clanPaketDao.findById(clanPaketDto.getId());
		if (clpak.isPresent())
			return null;// ima vec paket pod tim ID

		ClanPaket clanpaket = clanPaketDao.save(clpak.get());

		return clanpaket;

	}

	public ClanPaket findById(Long id) {
		// sa greskom obradjenom preko klase

		ClanPaket clanPaket = clanPaketDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ClanPaket", "id", id));

		return clanPaket;

	}

	public void deleteById(Long id) {
		clanPaketDao.deleteById(id);

	}

	public ClanPaketDTO update(ClanPaketDTO clanPaketdto) {

		Optional<ClanPaket> clp = clanPaketDao.findById(clanPaketdto.getId());

		if (!clp.isPresent())
			return null;

		// dohvati sva polja objekta i prepisi u Entity
		ClanPaket clanPaket = clp.get();

		MyUtil.prekopiraj(clanPaketdto, clanPaket);

		clanPaketDao.save(clanPaket);
		MyUtil.prekopiraj(clanPaket, clanPaketdto);
		return clanPaketdto;

	}

	public void save(ClanDTO clanDto, PaketDTO paketDto) {

		Optional<Clan> cl = clanService.clanDao.findById(clanDto.getId());

		Optional<Paket> pl = paketService.paketDAO.findById(paketDto.getId());
		ClanPaket clpl = new ClanPaket();
		clpl.setClan(cl.get());
		clpl.setPaket(pl.get());
		clanPaketDao.save(clpl);

		return;
	}
@Transactional
	public String aktiviraj(Long id) {
		// dohvati clanpaket.id aktiviraj paket , dohvati trajanje u minutama

		ClanPaket clpak = clanPaketDao.findById(id).get();
		if (clpak.getIstice() == null) {
			// long sad = System.currentTimeMillis();
			Date pp = new java.util.Date();
			Instant instant = pp.toInstant();

			// 1 sat =3600*1000milisec. ovde vreme u minutama cuvamo
			// String output = instantHourLater.toString();

			Integer istice = clpak.getPaket().getTrajanje();
			Duration duration = Duration.ofMinutes(istice);
			Instant kasnije = instant.plus(duration);
			Date enddat = Date.from(kasnije);
			clpak.setIstice(enddat);
			// mozda vratiti poruku aktivirano
			clanPaketDao.saveAndFlush(clpak);
			return "Aktiviran paket";
		} else {
			return "Paket sa tim brojem je vec aktiviran.Zvacu policiju";

		}

	}

	public Collection<ClanPaket> findAllClanPaket() {

		List<ClanPaket> spisak = new ArrayList<>();
		for (ClanPaket cc : clanPaketDao.findAll()) {
			spisak.add(cc);
		}
		return spisak;
	}

	public String kupljenPaket(ClanKupioPaketDTO clanKupioPaketDTO) {
		Optional<Clan> cl = clanDao.findById(clanKupioPaketDTO.getClanId());

		if (cl.isPresent()) {
			Optional<Paket> pk = paketDao.findById(clanKupioPaketDTO.getPaketId());
			if (pk.isPresent()) {
				ClanPaket noviCP = new ClanPaket();
				noviCP.setClan(cl.get());
				noviCP.setPaket(pk.get());
				noviCP.setDatum(new Date());
				
				clanPaketDao.save(noviCP);
				return "Zabelezena kupovina" + noviCP.getId();
			}
			return "Nepostojeci paket";
		}
		return "nepostojeci clan";
	}

}
