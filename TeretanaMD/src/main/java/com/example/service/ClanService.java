package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ClanDAO;
import com.example.dao.ClanPaketDAO;

import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.Grupa;
import com.example.domain.Paket;
import com.example.dto.ClanDTO;
import com.example.dto.ClanovaDTO;
import com.example.dto.KupljeniPaketiDTO;
import com.example.service.intf.ClanIF;

@Service
public class ClanService implements ClanIF {

	@Autowired
	ClanDAO clanDao;
	@Autowired
	ClanPaketDAO clanPaketDao;

	@Override
	@Transactional
	public List<Clan> findAll() {

		return clanDao.findAll();
	}

	@Override

	public ClanDTO save(ClanDTO clandto) {
		Clan cl = new Clan();
		BeanUtils.copyProperties(clandto, cl);
		clanDao.save(cl);
		BeanUtils.copyProperties(cl, clandto);
		return clandto;

	}

	@Override

	public Clan findById(Long id) {
		Optional<Clan> oc = clanDao.findById(id);
		Clan clan = oc.get();

		return clan;
	}

	@Override

	public void delete(Long id) {
		clanDao.deleteById(id);

	}

	@Override
	@Transactional
	public ClanDTO update(Long id, ClanDTO clandto) {

		Optional<Clan> cl_temp = clanDao.findById(clandto.getId());

		if (!cl_temp.isPresent())

			return null;

		// dohvati sva polja objekta i prepisi u Entity
		Clan clan = cl_temp.get();
		MyUtil.prekopiraj(clandto, clan);

		clanDao.save(clan);
		MyUtil.prekopiraj(clan, clandto);

		return clandto;

	}

	public Collection<Clan> findClans() {

		List<Clan> spisak = new ArrayList<>();
		for (Clan cc : clanDao.findAll()) {
			spisak.add(cc);
		}
		return spisak;
	}

	@Transactional
	public List<KupljeniPaketiDTO> paketiClana(Long id) {
		Optional<Clan> clan_temp = clanDao.findById(id);
		if (clan_temp.isPresent()) {
			Clan clan = clan_temp.get();

			Set<ClanPaket> paketiClana = clan.getClanPaketi();

			List<KupljeniPaketiDTO> pakclana = new ArrayList<>();

			for (ClanPaket pake : paketiClana) {
				KupljeniPaketiDTO nov = new KupljeniPaketiDTO();
				nov.setId(pake.getId());
				nov.setTicketExp(pake.getPaket().getTrajanje());
				nov.setTicketName(pake.getPaket().getIme());
				nov.setTicketPrice(pake.getPaket().getCena());
				nov.setTickettId(pake.getPaket().getId());

				pakclana.add(nov);
			}

			return pakclana;
		}
		return null;
	}

	@Override
	public Page<Clan> findAll(Pageable pageable) {
		// List<Clan> clanovi=clanDao.getAllClansByName(null);
		return clanDao.findAll(pageable);
	}

	public List<ClanovaDTO> findclanova() {
		// TODO Auto-generated method stub
		List<ClanovaDTO> x = clanDao.findClanCount();
		return x;
	}

	public long countByIme(String tenantName) {
		return clanDao.countByIme(tenantName);
	}

	@Override
	public Iterable<Clan> findByGrupa(Grupa grupa) {
		return clanDao.findByGrupa(grupa);

	}

}
