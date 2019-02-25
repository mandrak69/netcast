package com.example.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.domain.Clan;


public interface ClanDAO extends CrudRepository<Clan, Long> {

   
	Iterable<Clan> findByPrezime(String prezime);

	
    
}
