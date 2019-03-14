package com.example.wheather.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.wheather.entity.City;

@Repository
public interface CityDao extends MongoRepository<City, String>
{

	public City findByName(String name);
	
	
}
