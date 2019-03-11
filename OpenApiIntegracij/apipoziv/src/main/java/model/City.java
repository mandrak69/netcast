package model;

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
public class City  {
	private long id;
	
	private String name;
	
	public Coord coord;	
	
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

	public void setCod(float cod) {
		this.cod = cod;
	}

	public DBObject toDBObject() {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start("name", name).append("id", id).append("cod", cod).append("coord", coord);
		return builder.get();
	}

}
