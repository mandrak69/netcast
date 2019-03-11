package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {
	
	@JsonProperty("all")
	private float all;

	public Clouds() {
	}

	public float getAll() {
		return all;
	}

	public void setAll(float all) {
		this.all = all;
	}
}