package com.example.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.KnjigaTreninga;
import com.example.domain.Operater;
import com.example.domain.Trener;
import com.example.dto.KnjigaTreningaClanaDTO;
import com.example.dto.KnjigaTreningaDTO;

@Repository

public interface KnjigaTreningaDAO extends JpaRepository<KnjigaTreninga, Long> {

	List<KnjigaTreninga> findByClanPaket(ClanPaket clanPaket);
	List<KnjigaTreninga> findByTrener(Trener trener);
	List<KnjigaTreningaClanaDTO> findByVremeBetween(Date vreme, Date vremedo);
	List<KnjigaTreninga> findByOperater(Operater operater);
	long countByTrener(Trener trener);
	
	
	
	@Query("SELECT u FROM KnjigaTreninga u WHERE u.trener = :trener and u.id = :id")
	List<KnjigaTreningaClanaDTO> findKnjigaTreningaByTrenerAndIdNamedParams(
	  @Param("trener") long trener, 
	  @Param("id") long id);
	
	
	@Query("SELECT u FROM KnjigaTreninga u WHERE u.id = :id")
	List<KnjigaTreninga> findKnjigaTreningaByIdNamedParams(@Param("id") Long id);

	
    
}
