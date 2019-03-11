package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
	@JsonProperty("speed")
	private float speed;
	@JsonProperty("deg")
	private float deg;
	@JsonProperty("gust")
	private float gust;

	public Wind() {
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getDeg() {
		return deg;
	}

	public void setDeg(float deg) {
		this.deg = deg;
	}

	public float getGust() {
		return gust;
	}

	public void setGust(float gust) {
		this.gust = gust;
	}
}