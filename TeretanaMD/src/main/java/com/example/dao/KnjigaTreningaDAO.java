package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.KnjigaTreninga;

@Repository

public interface KnjigaTreningaDAO extends JpaRepository<KnjigaTreninga, Long> {

   

	
    
}
