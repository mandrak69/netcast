package com.example.service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.TeretanaMdApplication;
import com.example.dao.ClanDAO;
import com.example.dao.ClanPaketDAO;
import com.example.dao.KnjigaTreningaDAO;
import com.example.dao.OperaterDAO;
import com.example.dao.TrenerDAO;
import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.KnjigaTreninga;
import com.example.domain.Operater;
import com.example.domain.Trener;
import com.example.dto.KnjigaTreningIzvestajDTO;
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
	@Autowired
	OperaterDAO operaterDao;
	@Autowired
	private ClanPaketDAO clanPaketDao;
	@Autowired
	ClanPaketService clanPaketService;

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
	
	
	public String addNewWithOperater(KnjigaTreningIzvestajDTO knjigaTreningIzvestajDTO, HttpServletRequest httpre) {

		KnjigaTreninga novi_trening = new KnjigaTreninga();
		double zaplatiti =knjigaTreningIzvestajDTO.getCena();
		String opr = (String) httpre.getAttribute("operater_Email");

		Operater em = operaterDao.findByEmail(opr);

		novi_trening.setOperater(em);

		Optional<ClanPaket> pak = clanPaketDao.findById(knjigaTreningIzvestajDTO.getClanPaket());
		if (!pak.isPresent()) {
			return "Nepostojeci tiket sa tim ID";
		}
		else {
			
			
		}

		ClanPaket clPakett = pak.get();

		final Logger log = LoggerFactory.getLogger(TeretanaMdApplication.class);

	// proveri da li je aktiviran paket vremedo=null
		Date tiketIstekao = clPakett.getIstice();
		
		log.info("tiket istice " + tiketIstekao );
		if (tiketIstekao==null) {
			return "Kupon nije aktiviran-placen"+tiketIstekao;
		}

		// obracunaj popust na grupu
		zaplatiti = zaplatiti+clPakett.getPaket().getCena();
		log.info("cena   paket" + zaplatiti );
		if (clPakett.getClan().getGrupa() != null) {
			log.info("ima grupu" + clPakett.getId() + tiketIstekao + "/" + clPakett.getClan().getGrupa().getPopust());
			zaplatiti = zaplatiti * (100 - clPakett.getClan().getGrupa().getPopust()) / 100;
			log.info("popust na grupu" + zaplatiti );
		}

		Optional<Trener> tre = trenerDao.findById(knjigaTreningIzvestajDTO.getTrener());
		if (tre.isPresent()) {
			novi_trening.setTrener(tre.get());
			zaplatiti=zaplatiti + tre.get().getCena();
			log.info("trener" + tre.get().getCena() );
		}
		novi_trening.setCena(zaplatiti);
		
	//	clanPaketService.aktiviraj(clPakett.getId());
		log.info("konacna cena" +zaplatiti );
		
	

		tiketIstekao = clPakett.getIstice();
		novi_trening.setClanPaket(clPakett);
		novi_trening.setVreme(new Date());

		novi_trening.setVremedo(clPakett.getIstice());
		knjigaTreningaDao.save(novi_trening);
		return "Saved by operater " + opr;
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
				// lista.add(ktr);
				Long clanid = tren.getClanPaket().getClan().getId();

				log.info("Customers found" + tren.getId() + " with :" + id + "--"
						+ tren.getClanPaket().getClan().getId());

				if (id == tren.getClanPaket().getClan().getId()) {

					// zapis pripada clanu sa id
					lista.add(ktr);
				}
			}
			return lista;
		}
		return null;
	}

	@Override
	public List<KnjigaTreningaClanaDTO> getTreningClanBetween(long id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

		Calendar startday = Calendar.getInstance();
		startday.set(Calendar.DAY_OF_MONTH, 1);
		Date enddate = new Date();

		List<KnjigaTreninga> niz = knjigaTreningaDao.findByVremeBetween(startday.getTime(), enddate);
		List<KnjigaTreningaClanaDTO> lista = new ArrayList<>();
		for (KnjigaTreninga tren : niz) {

			Long clId = tren.getClanPaket().getClan().getId();
			if (clId == id) {
				KnjigaTreningaClanaDTO ktr = new KnjigaTreningaClanaDTO();
				BeanUtils.copyProperties(tren, ktr);
				if (tren.getTrener() == null) {

					ktr.setTrenerId(null);
				} else {
					ktr.setTrenerId(tren.getTrener().getId());
				}
				ktr.setPaketId(tren.getClanPaket().getPaket().getId());
				// lista.add(ktr);
				Long clanid = tren.getClanPaket().getClan().getId();

				if (id == tren.getClanPaket().getClan().getId()) {

					// zapis pripada clanu sa id
					lista.add(ktr);
				}
			}

		}
		return lista;
	}

	@Override
	public long setujNivoTrenera(Long id) {
		Optional<Trener> ima_tren = trenerDao.findById(id);
		if (ima_tren.isPresent()) {
			Trener tren = ima_tren.get();
			long novi_nivo = knjigaTreningaDao.countByTrener(tren) / 10;
			tren.setNivo(novi_nivo);
			trenerDao.save(tren);
			return novi_nivo;
		}
		return 0;
	}

	@Override
	public HashMap<Long, Double> getObracunClanBetween(long id) {

		Calendar startday = Calendar.getInstance();
		startday.set(Calendar.DAY_OF_MONTH, 1);
		Date enddate = new Date();
		final Logger log = LoggerFactory.getLogger(TeretanaMdApplication.class);
		List<KnjigaTreninga> niz = knjigaTreningaDao.findByVremeBetween(startday.getTime(), enddate);

		HashMap<Long, Double> mMap = new HashMap<Long, Double>();

		for (KnjigaTreninga tren : niz) {
			Long idclan = tren.getClanPaket().getClan().getId();

			log.info("--------" + tren.getClanPaket().getId());
			Double dugovanje = (Double) mMap.get(idclan);
			if (tren.getCena() != null) {
				if (dugovanje != null) {

					mMap.replace(idclan, dugovanje + tren.getCena());
				} else {
					// No such key
					mMap.put(idclan, tren.getCena());
				}
			}

		}
		return mMap;
	}
}
