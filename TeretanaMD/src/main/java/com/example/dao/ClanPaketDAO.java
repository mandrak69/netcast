package com.example.dao;

import java.util.Date;
import java.util.List;
//import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.Paket;


@Repository

public interface ClanPaketDAO extends JpaRepository<ClanPaket, Long> {

	
	List<ClanPaket> findByPaket(Paket paket);
	List<ClanPaket> findByClan(Clan Clan);
	List<ClanPaket> findByDatumBetween(Date odDatuma, Date doDatuma);
	long countByClan(Clan clan);

   

	
    
}
