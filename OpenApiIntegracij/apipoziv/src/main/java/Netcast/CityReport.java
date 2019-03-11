package Netcast;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import model.Clouds;
import model.Coord;
import model.Main;
import model.Rain;
import model.Sys;
import model.Weather;
import model.Wind;

public class CityReport {
	@JsonProperty("coord")
	public Coord CoordObject;
	@JsonProperty("weather")
	public ArrayList<Weather> weathers = new ArrayList<>();
	@JsonProperty("base")
	private String base;
	@JsonProperty("MainObject")
	Main MainObject;
	@JsonProperty("visibility")
	private float visibility;
	@JsonProperty("WindObject")
	Wind WindObject;
	@JsonProperty("RainObject")
	Rain RainObject;
	@JsonProperty("CloudsObject")
	Clouds CloudsObject;
	@JsonProperty("dt")
	private float dt;
	@JsonProperty("SysObject")
	Sys SysObject;
	@JsonProperty("id")
	private float id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("cod")
	private float cod;

	

	public CityReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coord getCoordObject() {
		return CoordObject;
	}

	public void setCoordObject(Coord coordObject) {
		CoordObject = coordObject;
	}

	

	public ArrayList<Weather> getWeather() {
		return weathers;
	}

	public void setWeather(ArrayList<Weather> weathers) {
		this.weathers = weathers;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMainObject() {
		return MainObject;
	}

	public void setMainObject(Main mainObject) {
		MainObject = mainObject;
	}

	public float getVisibility() {
		return visibility;
	}

	public void setVisibility(float visibility) {
		this.visibility = visibility;
	}

	public Wind getWindObject() {
		return WindObject;
	}

	public void setWindObject(Wind windObject) {
		WindObject = windObject;
	}

	public Rain getRainObject() {
		return RainObject;
	}

	public void setRainObject(Rain rainObject) {
		RainObject = rainObject;
	}

	public Clouds getCloudsObject() {
		return CloudsObject;
	}

	public void setCloudsObject(Clouds cloudsObject) {
		CloudsObject = cloudsObject;
	}

	public float getDt() {
		return dt;
	}

	public void setDt(float dt) {
		this.dt = dt;
	}

	public Sys getSysObject() {
		return SysObject;
	}

	public void setSysObject(Sys sysObject) {
		SysObject = sysObject;
	}

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCod() {
		return cod;
	}

	public void setCod(float cod) {
		this.cod = cod;
	}

	public DBObject toDBObject() {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start("name", name).append("Main", MainObject);
		return builder.get();
	}

}
