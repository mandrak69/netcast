package com.example.wheather.entity;

public class Wind {

	
	private Double speed;
	
	private Double deg;

	public Wind() {
		super();
	}


	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getDeg() {
		return deg;
	}

	public void setDeg(Double deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", deg=" + deg + "]";
	}
	
	
	
}
