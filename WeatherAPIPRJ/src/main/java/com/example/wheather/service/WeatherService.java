package com.example.wheather.service;

import com.example.weather.domain.Weather;

public interface WeatherService {
	public Weather getWeather(String city);
}
