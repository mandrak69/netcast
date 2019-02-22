package com.example.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.domain.Clan;


public interface ClanDAO extends CrudRepository<Clan, Long> {

    Clan findByMail(String mail);

	Iterable<Clan> findByPrezime(String prezime);

	
    
}
