package com.example.wheather.entity;

import java.util.Date;

public class SavedTemperatures {

	private Double temperature;
	
	private Date obtained;

	public SavedTemperatures() {
		super();
	}

	public SavedTemperatures(Double temperature, Date obtained) {
		super();
		this.temperature = temperature;
		this.obtained = obtained;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Date getObtained() {
		return obtained;
	}

	public void setObtained(Date obtained) {
		this.obtained = obtained;
	}

	@Override
	public String toString() {
		return "SavedTemperatures [temperature=" + temperature + ", obtained=" + obtained + "]";
	}
	
	
	
}
