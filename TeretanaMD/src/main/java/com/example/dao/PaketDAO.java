package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Paket;

@Repository

public interface PaketDAO extends JpaRepository<Paket, Long> {

   

	
    
}
