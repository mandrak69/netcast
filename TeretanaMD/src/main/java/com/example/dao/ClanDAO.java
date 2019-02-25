package com.example.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Clan;

@Repository
public interface ClanDAO extends CrudRepository<Clan, Long> {

   
	Iterable<Clan> findByPrezime(String prezime);

	
    
}
