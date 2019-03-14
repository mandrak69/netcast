package com.example.wheather.entity.dto;

import java.util.Date;



public class CityDto {

	private String id;
	
	private String name;
	
	private Date lastWeatherInfo;
	
	private Double valueInCelsius;

	public CityDto() {
		super();
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastWeatherInfo() {
		return lastWeatherInfo;
	}

	public void setLastWeatherInfo(Date lastWeatherInfo) {
		this.lastWeatherInfo = lastWeatherInfo;
	}

	public Double getValueInCelsius() {
		return valueInCelsius;
	}

	public void setValueInCelsius(Double valueInCelsius) {
		this.valueInCelsius = valueInCelsius;
	}

	@Override
	public String toString() {
		return "CityDto [id=" + id + ", name=" + name + ", lastWeatherInfo=" + lastWeatherInfo + ", valueInCelsius="
				+ valueInCelsius + "]";
	}
	
	
	
}
