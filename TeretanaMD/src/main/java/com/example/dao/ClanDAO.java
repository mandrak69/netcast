package com.example.dao;


import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Clan;
import com.example.domain.Grupa;
import com.example.dto.ClanovaDTO;

@Repository
public interface ClanDAO extends JpaRepository<Clan, Long> {

   

	Iterable<Clan> findByPrezime(String prezime);
	
	final String getAllClansByName= "from Clan order by value DESC";
	@Query(getAllClansByName)
	List<Clan> getAllClansByName(Pageable pageable);

	Iterable<Clan> findByGrupa(Grupa grupa);

	@Query("select new map(count(v) as cnt, clan.ime) from Clan clan group by clan.ime")
	public List<ClanovaDTO> findClanCount();
    
	
	List<Clan> findAllClanByIme(String ime );

	//List<Clan> findByIme(String imeclana,Pageable pageRequest);
	    
	long countByIme(String imeclana);


}
