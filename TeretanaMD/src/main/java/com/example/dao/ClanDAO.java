package com.example.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Clan;

@Repository
public interface ClanDAO extends JpaRepository<Clan, Long> {

   
	Iterable<Clan> findByPrezime(String prezime);

	
    
}
