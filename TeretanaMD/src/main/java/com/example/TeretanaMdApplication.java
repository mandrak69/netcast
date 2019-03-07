package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.dao.ClanDAO;
import com.example.dao.ClanPaketDAO;
import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.dao.PaketDAO;
import com.example.dao.TrenerDAO;
import com.example.domain.Paket;
import com.example.domain.Trener;

import java.util.Date;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@EnableScheduling
@SpringBootApplication
@EnableJSONDoc

public class TeretanaMdApplication {

	private static final Logger log = LoggerFactory.getLogger(TeretanaMdApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(TeretanaMdApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClanDAO repository, PaketDAO pakrepo, TrenerDAO trenrepo,ClanPaketDAO clprepo) {
		
		
		return (args) -> {
		/*	// save a couple of customers
			Clan c1 = new Clan("Jack", "Bauer");
			repository.save(c1);
			Clan c2 = new Clan("Chloe", "O'Brian");
			repository.save(c2);
			Clan c3 = new Clan("Kim", "Bauer");
			repository.save(c3);
			Clan c4 = new Clan("David", "Palmer");
			Clan c5 = new Clan("Michelle", "Dessler");
			repository.save(c4);
			repository.save(c5);
			Paket p1 = new Paket("paket1", 1234.00, 30);
			pakrepo.save(p1);
			Paket p2 = new Paket("paket2", 222.00, 60);
			pakrepo.save(p2);
			Paket p3 = new Paket("paket3", 333.00, 90);
			pakrepo.save(p3);
			Trener t1 = new Trener("trener1", "tr1prez", 123.00, (long) 1);

			trenrepo.save(t1);
			Trener t2 = new Trener("trener2", "tr2prez", 222.00, (long) 0);

			trenrepo.save(t2);
			Trener t3 = new Trener("trener3", "tr3prez", 333.00, (long) 0);

			trenrepo.save(t3);
			Trener t4 = new Trener("trener4", "tr4prez", 444.00, (long) 2);

			trenrepo.save(t4);
			
			ClanPaket cp1=new ClanPaket(c2,p1);
			cp1.setDatum(new Date());
			clprepo.save(cp1);
			
			ClanPaket cp2=new ClanPaket(c1,p1);
			cp2.setDatum(new Date());
			clprepo.save(cp2);
			ClanPaket cp3=new ClanPaket(c2,p2);
			cp3.setDatum(new Date());
			clprepo.save(cp3);
			ClanPaket cp4=new ClanPaket(c4,p3);
			cp4.setDatum(new Date());
			clprepo.save(cp4);
			
			
			
			*/

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Clan clan : repository.findAll()) {
				log.info(clan.toString());
			}
			log.info("");

			// fetch an individual clan by ID
			repository.findById(1L).ifPresent(clan -> {
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
			// log.info(bauer.toString());
			// }
			log.info("");

		};
	}

}
