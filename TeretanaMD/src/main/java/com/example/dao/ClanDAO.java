package com.example.dao;


import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Clan;

@Repository
public interface ClanDAO extends JpaRepository<Clan, Long> {

   

	Iterable<Clan> findByPrezime(String prezime);
	@Query(getAllClansByName)
	List<Clan> getAllClansByName(Pageable pageable);

	final String getAllClansByName= "from Clan order by value DESC";

	
    
}
