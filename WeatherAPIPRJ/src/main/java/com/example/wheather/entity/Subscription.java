package com.example.wheather.entity;

public class Subscription {

	private String city;
	
	private Integer subscriptionType;
	
	

	public Subscription() {
		super();
	}

	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(Integer tipPretplate) {
		this.subscriptionType = tipPretplate;
	}

	@Override
	public String toString() {
		return "Subscription [city=" + city + ", tipPretplate=" + subscriptionType + "]";
	}
	
	
	
}
