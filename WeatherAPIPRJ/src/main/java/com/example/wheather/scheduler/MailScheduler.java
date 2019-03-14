package com.example.wheather.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.wheather.inter.UserIF;

@Component
public class MailScheduler {

	
	UserIF userIf;
	MailService mailService;

	@Autowired
	public MailScheduler(UserIF userIf, MailService mailService) {

		
		this.userIf = userIf;
		this.mailService = mailService;
	}

	@Scheduled(cron = "0 0 * ? * * ")
	public void sendEmailByHour() {
		userIf.sendbySub(1, mailService);
	}

	@Scheduled(cron = "0 0 0 ? * * ")
	public void sendEmail12h() {

		userIf.sendbySub(12, mailService);
	}

	@Scheduled(cron = "0 0 0 ? * * ")
	public void sendZeroOur() {

		userIf.sendbySub(24, mailService);

		

	}

}
