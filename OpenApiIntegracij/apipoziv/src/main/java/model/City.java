package model;



import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;


@Document
public class City  {
	private String id;
	@JsonProperty("id")
	private long cityId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("coord")
	public Coord coord;	
	@JsonProperty("cod")
	private float cod;

	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Coord getCoord() {
		return coord;
	}


	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public long getCityId() {
		return cityId;
	}


	public void setCityId(long cityId) {
		this.cityId = cityId;
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
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start("name", name).append("id", id).append("cod", cod).append("coord", coord);
		return builder.get();
	}

}
