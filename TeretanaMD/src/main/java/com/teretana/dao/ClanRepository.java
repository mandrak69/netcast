package com.teretana.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teretana.model.Clan;

public interface ClanRepository extends CrudRepository<Clan, Long> {

    List<Clan> findByMail(String mail);

	Iterable<Clan> findByPrezime(String prezime);

	
    
}
