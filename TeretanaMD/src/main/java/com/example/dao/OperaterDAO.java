package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Operater;



@Repository
public interface OperaterDAO extends JpaRepository<Operater, Long>{
	
	public Operater findByEmail(String email);
	public Operater findByEmailAndPassword(String email, String password);
}
