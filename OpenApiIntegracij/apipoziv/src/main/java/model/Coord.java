package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord {
	@JsonProperty("lon")
	private float lon;
	@JsonProperty("lat")
	private float lat;

	public Coord() {
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}
}