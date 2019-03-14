package com.example.wheather.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.wheather.dao.CityDao;
import com.example.wheather.entity.City;
import com.example.wheather.inter.TemplateIF;
import com.example.wheather.properties.WeatherProperty;

@Service
public class Template implements TemplateIF {

	@Autowired
	CityDao cityDao;

	public Template() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<City> getAllCities(List<City> cities) {

		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		List<City> updatedCities = new ArrayList<>();
		for (City city : cities) {
			headers.set(WeatherProperty.keyName, WeatherProperty.keyValue);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			String url = WeatherProperty.url + city.getName();
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<City> response = template.exchange(url, HttpMethod.GET, entity, City.class);
			City prcity = response.getBody();
			updatedCities.add(prcity);

		}
		return updatedCities;
	}
}
