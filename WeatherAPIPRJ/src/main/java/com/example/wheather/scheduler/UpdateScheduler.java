package com.example.wheather.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.wheather.entity.User;
import com.example.wheather.inter.CityIF;
import com.example.wheather.inter.TemplateIF;

@Component
public class UpdateScheduler {
	
	@Autowired
	CityIF cityIf;
	
	@Scheduled(cron="0 0 22/1 1/1 * ?")
	
	public void getAllCities() {
		cityIf.updateCities();
	}
	
	

}
