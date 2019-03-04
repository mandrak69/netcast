package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.ClanPaket;
import com.example.domain.KnjigaTreninga;
import com.example.domain.Operater;
import com.example.domain.Trener;

@Repository

public interface KnjigaTreningaDAO extends JpaRepository<KnjigaTreninga, Long> {

	List<KnjigaTreninga> findByClanPaket(ClanPaket clanPaket);
	List<KnjigaTreninga> findByTrener(Trener trener);
	List<KnjigaTreninga> findByVremeBetween(Date vreme, Date vremedo);
	List<KnjigaTreninga> findByOperater(Operater operater);


	
    
}
