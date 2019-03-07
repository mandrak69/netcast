package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.example.TeretanaMdApplication;
import com.example.dao.ClanDAO;
import com.example.dao.KnjigaTreningaDAO;
import com.example.dao.TrenerDAO;
import com.example.domain.Clan;
import com.example.domain.KnjigaTreninga;
import com.example.domain.Operater;
import com.example.domain.Trener;
import com.example.dto.KnjigaTreningaClanaDTO;
import com.example.dto.KnjigaTreningaDTO;
import com.example.security.LoginService;
import com.example.service.intf.KnjigaTreningaIF;

@Service
public class KnjigaTreningaService implements KnjigaTreningaIF {
	@Autowired
	KnjigaTreningaDAO knjigaTreningaDao;
	@Autowired
	KnjigaTreningaIF knjigaTreningaIF;
	@Autowired
	LoginService loginService;
	@Autowired
	ClanDAO clanDao;
	@Autowired
	TrenerDAO trenerDao;

	@Override
	public KnjigaTreningaDTO findById(Long id) {
		Optional<KnjigaTreninga> oc = knjigaTreningaDao.findById(id);
		KnjigaTreningaDTO target = new KnjigaTreningaDTO();
		BeanUtils.copyProperties(oc.get(), target);

		return target;
	}

	public void delete(Long id) {
		knjigaTreningaDao.deleteById(id);

	}

	public List<KnjigaTreninga> findByOperater(Operater operater) {

		List<KnjigaTreninga> oc = knjigaTreningaDao.findByOperater(operater);

		return oc;
	}

	@Override
	public KnjigaTreningaDTO save(KnjigaTreningaDTO knjigaTreningadto) {

		KnjigaTreninga target = new KnjigaTreninga();
		BeanUtils.copyProperties(knjigaTreningadto, target);
		knjigaTreningaDao.save(target);
		KnjigaTreningaDTO knjDTO = new KnjigaTreningaDTO();
		BeanUtils.copyProperties(target, knjDTO);
		return knjDTO;
	}

	// Zapis o terminu vezbanja dopunjen operaterom koji vrsi upis
	@Override
	public KnjigaTreningaDTO addNewWithOperater(KnjigaTreningaDTO knjigaTreningadto, HttpServletRequest httpre) {
		KnjigaTreninga target = new KnjigaTreninga();
		BeanUtils.copyProperties(knjigaTreningadto, target);

		Operater em = loginService.getOperater(httpre.getHeader("token"));

		target.setOperater(em);

		knjigaTreningaDao.save(target);
		KnjigaTreningaDTO knjDTO = new KnjigaTreningaDTO();
		BeanUtils.copyProperties(target, knjDTO);
		return knjDTO;
	}

	@Override
	public KnjigaTreningaDTO update(KnjigaTreningaDTO knjigaTreningadto) {
		Optional<KnjigaTreninga> target = knjigaTreningaDao.findById(knjigaTreningadto.getId());
		KnjigaTreninga zapis = target.get();
		BeanUtils.copyProperties(knjigaTreningadto, zapis);

		knjigaTreningaDao.save(zapis);
		KnjigaTreningaDTO knjDTO = new KnjigaTreningaDTO();
		BeanUtils.copyProperties(zapis, knjDTO);
		return knjDTO;

	}

	@Override
	public Page<KnjigaTreningaDTO> findAll(Pageable pageable) {

		return null;
	}

//  pronadji sve zapise iz KnjigaTreninga  koje pripadaju clanu
	@Override
	public List<KnjigaTreningaClanaDTO> findByClan(long id, long trener) {
		// List<KnjigaTreninga> lista =
		// knjigaTreningaDao.findKnjigaTreningaByIdNamedParams(clan_id);

		List<KnjigaTreningaClanaDTO> rr = knjigaTreningaDao.findKnjigaTreningaByTrenerAndIdNamedParams(id, trener);
		return rr;
	}

	// find all records from KnjigaTreninga for member with this id
	@Override
	public List<KnjigaTreningaClanaDTO> findByClan(long id) {
		final Logger log = LoggerFactory.getLogger(TeretanaMdApplication.class);
		Optional<Clan> clOp = clanDao.findById(id);
		if (clOp.isPresent()) {
			Clan clanSaId = clOp.get();
			

			List<KnjigaTreningaClanaDTO> lista = new ArrayList<>();
			for (KnjigaTreninga tren : knjigaTreningaDao.findAll()) {
				KnjigaTreningaClanaDTO ktr = new KnjigaTreningaClanaDTO();
				BeanUtils.copyProperties(tren, ktr);
				if (tren.getTrener() == null) {

					ktr.setTrenerId(null);
				} else {
					ktr.setTrenerId(tren.getTrener().getId());
				}
				

				ktr.setPaketId(tren.getClanPaket().getPaket().getId());
			//	lista.add(ktr);
				  Long clanid = tren.getClanPaket().getClan().getId();
log.info("Customers found"+tren.getId()+" with :"+id+"--"+tren.getClanPaket().getClan().getId());
				if (id==tren.getClanPaket().getClan().getId()) {
					
					// zapis pripada clanu sa id
					 lista.add(ktr);
				}
			}
			return lista;
		}
		return null;
	}

}
