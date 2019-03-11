package WeatherInfo;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

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

@Document
public class CityReport {
	
	public Coord CoordObject;
	
	public ArrayList<Weather> weathers = new ArrayList<>();
	
	private String base;
	
	Main MainObject;
	
	private float visibility;
	
	Wind WindObject;
	
	Rain RainObject;
	
	Clouds CloudsObject;

	private float dt;
	
	Sys SysObject;
	
	private long id;
	
	private String name;
	
	private long cod;

	

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

	public void setId(long id) {
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

	public void setCod(long cod) {
		this.cod = cod;
	}

	public DBObject toDBObject() {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start("name", name).append("id", id).append("cod", cod).append("coord", CoordObject);
		return builder.get();
	}

}
