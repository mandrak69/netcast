package com.example.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.dao.PaketDAO;
import com.example.domain.Paket;
import com.example.dto.PaketDTO;
import com.example.service.intf.PaketIF;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;



@Service
public class PaketService implements PaketIF{
		
		@Autowired
		PaketDAO paketDAO;
		
		
		@Override
		public PaketDTO save(PaketDTO paketdto) {
			Paket cl = new Paket();
			BeanUtils.copyProperties(paketdto, cl);
				
			paketDAO.save(cl);
			BeanUtils.copyProperties(cl, paketdto);
		return paketdto;

		}
		@Override
		public Paket findById(Long id) {
			Optional<Paket> oc = paketDAO.findById(id);
			Paket paket = oc.get();
			
		  return paket ;
		}
		@Override
		public void delete(Long  id) {
			paketDAO.deleteById(id);

		}
		
		
		
		
		@Transactional
		@Override
		public PaketDTO update(PaketDTO paketdto) {

			Optional<Paket> imaga = paketDAO.findById(paketdto.getId());

			if (!imaga.isPresent())
			
				return null;
				
			
			//dohvati sva polja objekta i prepisi u Entity
		    Paket paket = imaga.get();
			MyUtil.prekopiraj(paketdto,paket);
			
			paketDAO.save(paket);
			MyUtil.prekopiraj(paket,paketdto);
			return paketdto;
			
		}
		
		public Collection<Paket> findPakets(){
			
			List<Paket> paketi = new ArrayList<>();
			for(Paket pak: paketDAO.findAll()) {
				paketi.add(pak);
			}
			return paketi;
		}
		
		
		@Override
		public Page<Paket> findAll(Pageable pageable) {
		 //  List<Clan> clanovi=clanDao.getAllClansByName(null);
			return paketDAO.findAll(pageable);
		}
		
	
		
		
		
	}


