package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
	@JsonProperty("temp")
	private float temp;
	@JsonProperty("pressure")
	private float pressure;
	@JsonProperty("humidity")
	private float humidity;
	@JsonProperty("temp_min")
	private float temp_min;
	@JsonProperty("temp_max")
	private float temp_max;

	public Main() {
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}

	public float getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}
}