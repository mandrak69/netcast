package model;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.aksingh.owmjapis.model.param.Main;
import net.aksingh.owmjapis.model.param.Weather;
import net.aksingh.owmjapis.model.param.Wind;

public class Netcast {
	
	@JsonProperty("coord")
	private @Valid Coord coord;
	
	@JsonProperty("weather")
	private @Valid List<Weather> weather;
	@JsonProperty("base")
	private String base;
	
	@JsonProperty("main")
	private @Valid Main main;
	@JsonProperty("visibility")
	private Integer visibility;
	
	@JsonProperty("wind")
	private @Valid Wind wind;
	
	@JsonProperty("rain")
	private @Valid Rain rain;
	
	@JsonProperty("clouds")
	private @Valid Clouds clouds;
	@JsonProperty("dt")
	private Integer dt;
	
	@JsonProperty("sys")
	private @Valid Sys sys;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("cod")
	private Integer cod;
	
	@JsonIgnore
	private @Valid Map<String, Object> additionalProperties;

	public Netcast(@Valid List<Weather> weather, @Valid Map<String, Object> additionalProperties) {
		this.weather = weather;
		this.additionalProperties = additionalProperties;
	}

	public @Valid Coord getCoord() {
		return coord;
	}

	public void setCoord(@Valid Coord coord) {
		this.coord = coord;
	}

	public @Valid List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(@Valid List<Weather> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public @Valid Main getMain() {
		return main;
	}

	public void setMain(@Valid Main main) {
		this.main = main;
	}

	public Integer getVisibility() {
		return visibility;
	}

	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	public @Valid Wind getWind() {
		return wind;
	}

	public void setWind(@Valid Wind wind) {
		this.wind = wind;
	}

	public @Valid Rain getRain() {
		return rain;
	}

	public void setRain(@Valid Rain rain) {
		this.rain = rain;
	}

	public @Valid Clouds getClouds() {
		return clouds;
	}

	public void setClouds(@Valid Clouds clouds) {
		this.clouds = clouds;
	}

	public Integer getDt() {
		return dt;
	}

	public void setDt(Integer dt) {
		this.dt = dt;
	}

	public @Valid Sys getSys() {
		return sys;
	}

	public void setSys(@Valid Sys sys) {
		this.sys = sys;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public @Valid Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(@Valid Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}