package com.example.wheather.inter;

import java.util.List;

import com.example.wheather.entity.City;

import net.aksingh.owmjapis.model.CurrentWeather;

public interface CityIF {

	public City getCityByName(String name);
	
	public City getByCountry(String country);
	
	public List<City> findAll();
	
	public void updateCities();
	
	public CurrentWeather getNewWeather(int id);
	
}
