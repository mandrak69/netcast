package com.example.wheather.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.wheather.dao.CityDao;
import com.example.wheather.entity.City;
import com.example.wheather.entity.CurrentWeath;
import com.example.wheather.entity.SavedTemperatures;
import com.example.wheather.entity.dto.CityDto;
import com.example.wheather.inter.CityIF;
import com.example.wheather.inter.TemplateIF;
import com.example.wheather.properties.WeatherProperty;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

@Service
public class CityService implements CityIF {
	@Autowired
	CityDao cityDao;
	@Autowired
	TemplateIF template;

/*	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
*/
	public CityService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public CityService(CityDao cityDao, TemplateIF template) {

		this.cityDao = cityDao;
		this.template = template;

	}

	@Override
	public City getCityByName(String name) {

		return cityDao.findByName(name);
	}

	@Override
	public City getByCountry(String country) {

		return null;
	}

	@Override
	public List<City> findAll() {
		List<City> cities = cityDao.findAll();
		
		return cities;
	}

	@Override
	public CurrentWeather getNewWeather(int id) {

		OWM owm = new OWM(WeatherProperty.keyValue);
		// getting current weather data for the "London" city
		// CurrentWeather cwd = owm.currentWeatherByCityName("Belgrade");
		CurrentWeather cwd=null;
		try {
			cwd = owm.currentWeatherByCityId(id);		
			  CurrentWeath novi=new CurrentWeath(); 		  
	//  preko 
			//  novi.setCurrentWeath(cwd);
			//  currentWeathDao.save(novi);
			 
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cwd;

	}
public CurrentWeather getWeByResponseID(String id) {
		
		RestTemplate restTemplate=new RestTemplate();
		
	String response = restTemplate.getForObject(
			"https://api.openweathermap.org/data/2.5/weather?q="+id+"&APPID=e4801cffdffb979080eece7098f46150", String.class);
	
	Gson gson = new Gson();
	 JsonParser parser = new JsonParser();
	 JsonObject object = (JsonObject) parser.parse(response);
	return null;
	}
	
	// da li ima logike raditi preko zahteva pored klase..?
	public CurrentWeather getWeByResponse(String cityName) {
		
		RestTemplate restTemplate=new RestTemplate();
		
	String response = restTemplate.getForObject(
			"https://api.openweathermap.org/data/2.5/weather?q="+cityName+",uk&APPID=e4801cffdffb979080eece7098f46150", String.class);
	
	Gson gson = new Gson();
	 JsonParser parser = new JsonParser();
	 JsonObject object = (JsonObject) parser.parse(response);
	return null;
	}
	
	@Override
	public void updateCities() {
		List<City> citylist= cityDao.findAll();
		
		for (City city : citylist) {
			CurrentWeather vreme = getNewWeather(city.getId());		
			cityDao.save(city);
			
		}
	}
}
