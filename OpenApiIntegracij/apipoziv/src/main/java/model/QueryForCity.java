package model;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.DailyWeatherForecast;

public class QueryForCity {
	
	OWM owm = new OWM("e4801cffdffb979080eece7098f46150");
	
	public  DailyWeatherForecast dailyWeatherForecast(long id) throws APIException { // object of "OWM" class
	//	OWM owm = new OWM("e4801cffdffb979080eece7098f46150");

		DailyWeatherForecast dwf = owm.dailyWeatherForecastByCityId(792680);

		return dwf;
	}

	public  CurrentWeather currentWeatherByCityId(long id) throws APIException {
	//	OWM owm = new OWM("e4801cffdffb979080eece7098f46150");
		CurrentWeather cwd = owm.currentWeatherByCityId(792680);
		return cwd;

	}
}
