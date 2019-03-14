package com.example.wheather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wheather.entity.City;
import com.example.wheather.entity.dto.CityDto;
import com.example.wheather.inter.CityIF;
import com.example.wheather.inter.UserIF;
import com.example.wheather.security.LoginService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	CityIF cityIf;
	//UserIF userIf;
	LoginService loginService;
	
	
	public WeatherController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public WeatherController(CityIF cityIf, UserIF userIf,LoginService loginService) {
		
		this.cityIf = cityIf;
		//this.userIf = userIf;
		this.loginService=loginService;
	}


	@RequestMapping("/forecast/{name}")
	public City getForecast(@PathVariable String name) {
		return cityIf.getCityByName(name);
		
	}
		
	
	@GetMapping("city/findAll")
	public List<City> findAll(){
		return cityIf.findAll();
	}
	
	
}
