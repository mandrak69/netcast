package com.example.weather.domain;

import javax.validation.constraints.NotNull;

public class WeatherSearchForm {
    @NotNull
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return "WeatherSearchForm(City: " + this.city + ")";
    }
}
