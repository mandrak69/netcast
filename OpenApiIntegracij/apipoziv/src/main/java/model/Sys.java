package model;

import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys {
	@JsonProperty("type")
	private Integer type;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("message")
	private Double message;
	@JsonProperty("country")
	private String country;
	@JsonProperty("sunrise")
	private Integer sunrise;
	@JsonProperty("sunset")
	private Integer sunset;
	
	@JsonIgnore
	private @Valid Map<String, Object> additionalProperties;

	public Sys(@Valid Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMessage() {
		return message;
	}

	public void setMessage(Double message) {
		this.message = message;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getSunrise() {
		return sunrise;
	}

	public void setSunrise(Integer sunrise) {
		this.sunrise = sunrise;
	}

	public Integer getSunset() {
		return sunset;
	}

	public void setSunset(Integer sunset) {
		this.sunset = sunset;
	}

	public @Valid Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(@Valid Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}