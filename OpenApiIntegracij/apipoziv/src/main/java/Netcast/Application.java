package Netcast;

import java.lang.reflect.Constructor;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Hello world!
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Coord;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String response = restTemplate.getForObject(
					"https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=e4801cffdffb979080eece7098f46150", String.class);
			
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonObject object = (JsonObject) parser.parse(response);
			CityReport emp = gson.fromJson(object, CityReport.class); 
			Set<Entry<String, JsonElement>> niz = object.entrySet();
			for(Entry<String, JsonElement> kluc:niz) {
			log.info(kluc.getValue()+"eno objekta"+kluc.getKey());
			
			//	Class<?> c = Class.forName("model.Coord.java");
			//	Constructor<?> cons = c.getConstructor(String.class);
			//	Object obj = cons.newInstance(kluc.getValue());
				
				
			}
			/*
			log.info("eno objekta"+emp.getId());
			log.info("eno objekta"+emp.getBase());
			log.info("eno objekta"+emp.getDt());
			log.info("eno objekta"+emp.getName());
			log.info("eno objekta"+emp.getVisibility());
			log.info("eno objekta"+emp.getCoordObject());
			log.info("eno objekta"+emp.getMainObject());
			log.info("eno objekta"+emp.getSysObject());
			log.info("eno objekta"+emp.getRainObject());
			*/
			CityClassToMongo.upisiZapisOGradu(emp);
			
		};
	}
}