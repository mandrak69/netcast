package com.teretana.TeretanaMD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.teretana.dao.ClanRepository;
import com.teretana.model.Clan;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(ClanRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Clan(1L,"Jack", "Bauer"));
			repository.save(new Clan(2L,"Chloe", "O'Brian"));
			repository.save(new Clan(3L,"Kim", "Bauer"));
			repository.save(new Clan(4L,"David", "Palmer"));
			repository.save(new Clan(5L,"Michelle", "Dessler"));

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
