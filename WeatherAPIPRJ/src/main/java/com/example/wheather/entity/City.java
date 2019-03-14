package com.example.wheather.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "city")
public class City {
	@Id
	private String _id;
	
	private String name;
	
	private Coordinates coord;

	private Sys sys;

	private Long dt;

	private int id;
	
	public City() {
		super();
	}

	

	public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coor) {
		this.coord = coor;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	
	public Long getDt() {
		return dt;
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", coord=" + coord + ", sys=" + sys + ", dt=" + dt + "]";
	}

	
}
