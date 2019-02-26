package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Paket;

@Repository

public interface PaketDAO extends CrudRepository<Paket, Long> {

   

	
    
}
