package com.example.wheather.entity;

public class Main {

	private Double temp;
	
	private Double humidity;
	
	private Integer pressure;
	
	private Double temp_min;
	
	private Double temp_max;

	public Main() {
		super();
	}


	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}

	public Double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}

	@Override
	public String toString() {
		return "Main [temp=" + temp + ", humidity=" + humidity + ", pressure=" + pressure + ", temp_min=" + temp_min
				+ ", temp_max=" + temp_max + "]";
	}
	
	
	
	
}
