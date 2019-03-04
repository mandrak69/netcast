package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.config.JwtFilter;
import com.example.dao.ClanDAO;
import com.example.domain.Clan;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;






@SpringBootApplication
public class TeretanaMdApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secure/*");

		return registrationBean;
	}

	private static final Logger log = LoggerFactory.getLogger(TeretanaMdApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(TeretanaMdApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(ClanDAO repository) {
		return (args) -> {
			// save a couple of customers
			Clan cl = new Clan("Jack", "Bauer");
			repository.save(cl);
			repository.save(new Clan("Chloe", "O'Brian"));
			repository.save(new Clan("Kim", "Bauer"));
			repository.save(new Clan("David", "Palmer"));
			repository.save(new Clan("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Clan clan : repository.findAll()) {
				log.info(clan.toString());
			}
			log.info("");

			// fetch an individual clan by ID
			repository.findById(1L)
				.ifPresent(clan -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(clan.toString());
					log.info("");
				});

			// fetch clan by last name
			log.info("clan sa findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByPrezime("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		
			};
	}

}
