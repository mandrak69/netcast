package com.example.wheather.entity.dto;

public class EmailForecast {

	private String city;
	
	private Double curentTemperature;
	
	private Double maxTemperature;
	
	private Double minTemperature;

	public EmailForecast() {
		super();
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getCurentTemperature() {
		return curentTemperature;
	}

	public void setCurentTemperature(Double curentTemperature) {
		this.curentTemperature = curentTemperature;
	}

	public Double getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(Double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public Double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(Double minTemperature) {
		this.minTemperature = minTemperature;
	}

	@Override
	public String toString() {
		return " City=" + city + ", Curent Temperature=" + curentTemperature + ",\n Max Temperature="
				+ maxTemperature + ",\n Min Temperature=" + minTemperature + "\n";
	}
	
	
	
}
