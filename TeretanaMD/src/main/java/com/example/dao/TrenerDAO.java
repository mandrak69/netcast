package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Trener;


@Repository

public interface TrenerDAO extends CrudRepository<Trener, Long> {

   

	
    
}
