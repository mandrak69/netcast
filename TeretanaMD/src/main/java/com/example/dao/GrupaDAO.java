package com.example.dao;


import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Clan;
import com.example.domain.Grupa;

@Repository
public interface GrupaDAO extends JpaRepository<Grupa, Long> {

   

	Iterable<Grupa> findByIme(String ime);
	@Query(getAllGrupasByIme)
	List<Clan> getAllClansByIme(Pageable pageable);

	final String getAllGrupasByIme= "from Grupa order by value DESC";

	
    
}
