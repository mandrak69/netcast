package com.example.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dao.PaketDAO;

import com.example.domain.Paket;
import com.example.dto.PaketDTO;
import com.example.service.intf.PaketIF;


import java.net.URI;
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
		public PaketDTO saves(PaketDTO paketdto) {
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
		
		@Override
		public ResponseEntity<Object> create(PaketDTO paketdto) {
			Paket cl = new Paket();
			BeanUtils.copyProperties(cl, paketdto);
			Paket savedPaket = paketDAO.save(cl);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(savedPaket.getId()).toUri();

			return ResponseEntity.created(location).build();
			}
		
		
		@Transactional
		@Override
		public ResponseEntity<Object> update(PaketDTO paketdto) {

			Optional<Paket> clp = paketDAO.findById(paketdto.getId());

			if (!clp.isPresent())
			{
				return ResponseEntity.notFound().build();
				
			}  else 
			{
			//dohvati sva polja objekta i prepisi u Entity
		    Paket paket = clp.get();
			utility.prekopiraj(paketdto,paket);
			
			paketDAO.save(paket);

			return ResponseEntity.noContent().build();
			}
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
			// TODO Auto-generated method stub
			return paketDAO.findAll(pageable);
		}
		
		
	}


