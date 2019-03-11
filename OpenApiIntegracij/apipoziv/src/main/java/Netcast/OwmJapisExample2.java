package Netcast;

import net.aksingh.owmjapis.core.OWM;

import java.lang.reflect.Field;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

public class OwmJapisExample2 {

    public static void main(String[] args)
            throws APIException, IllegalArgumentException, IllegalAccessException {

        // declaring object of "OWM" class
        OWM owm = new OWM("e4801cffdffb979080eece7098f46150");

        // getting current weather data for the "London" city
  //      CurrentWeather cwd = owm.currentWeatherByCityName("Belgrade");
        CurrentWeather cwd=owm.currentWeatherByCityId(792680) ;
        

        // checking data retrieval was successful or not
        if (cwd.hasRespCode() && cwd.getRespCode() == 200) {

            // checking if city name is available
            if (cwd.hasCityName()) {
                //printing city name from the retrieved data
                System.out.println("City: " + cwd.getCityName());
                Field[] polja = cwd.getClass().getDeclaredFields();
                for(Field p:polja) {
                	p.setAccessible(true);
                	 System.out.println(p.getName().toString());
                	
                }
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