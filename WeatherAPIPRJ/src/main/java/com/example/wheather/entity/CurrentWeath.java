package com.example.wheather.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import net.aksingh.owmjapis.model.CurrentWeather;

@Document(collection="currentw")
public class CurrentWeath {

	@Id
	private String _id;
	
//	private CurrentWeather currentWeath;
	private Date lastUpdate=new Date();
	
	public CurrentWeath() {
		// TODO Auto-generated constructor stub
	}





	

	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}





	

	@Override
	public String toString() {
		return "CurrentWeath [_id=" + _id + ", currentWeath="  + "]";
	}


	public Date getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
