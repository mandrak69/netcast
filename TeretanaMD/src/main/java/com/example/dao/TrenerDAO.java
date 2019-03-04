package com.example.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.example.domain.Trener;


@Repository

public interface TrenerDAO extends JpaRepository<Trener, Long> {

	

	
    
}
