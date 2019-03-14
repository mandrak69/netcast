package com.example.wheather.entity;

public class Coordinates {

	
	private Double lon;
	
	private Double lat;

	public Coordinates() {
		super();
	}

	public Coordinates(Double lon, Double lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Coordinates [lon=" + lon + ", lat=" + lat + "]";
	}
	
	
}
