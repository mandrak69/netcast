package WeatherInfo;

import net.aksingh.owmjapis.core.OWM;

import java.lang.reflect.Field;

import model.QueryForCity;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.DailyWeatherForecast;

public class OwmJapisExample2 {

    public static void main(String[] args)
            throws APIException, IllegalArgumentException, IllegalAccessException {

       //  object of "OWM" class
        OWM owm = new OWM("e4801cffdffb979080eece7098f46150");

  
         DailyWeatherForecast dwf = owm.dailyWeatherForecastByCityId(792680);
        CurrentWeather cwd=owm.currentWeatherByCityId(792680) ;
        
       
        
    	
        // checking data retrieval was successful or not
        if (cwd.hasRespCode() && cwd.getRespCode() == 200) {

           // checking if city name is available
            if (cwd.hasCityName()) {
                //printing city name from the retrieved data
                System.out.println("City: " + cwd.getCityName());
              
            }

            // checking if max. temp. and min. temp. is available
            if (cwd.hasMainData() && cwd.getMainData().hasTempMax() && cwd.getMainData().hasTempMin()) {
                // printing the max./min. temperature
                System.out.println("Temperature: " + cwd.getMainData().getTempMax()
                            + "/" + cwd.getMainData().getTempMin() + "\'K"+" cityID "+cwd.getCityId());
            }
        }
    }
}