package com.example.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Clan;

import com.example.service.MailService;




@RestController
public class RegistrationController {

	@Autowired
	private MailService notificationService;

	/*@Autowired
	private Clan clan;*/

	
	@RequestMapping("send-mail")
	public String send() {

		Clan clan = new Clan();
		clan.setIme("Teretana");
		clan.setPrezime("MD");
		clan.setEmail("dm2005ss@gmail.com");

		
		try {
			notificationService.sendEmail(clan,"Tekst propratni uz mail");
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Your mail sent to user."+clan.getEmail();
	}

	
	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException {
		Clan clan = new Clan();
		clan.setIme("Teretana");
		clan.setPrezime("MD");
		clan.setEmail("dm2005ss@gmail.com");
		
		try {
			notificationService.sendEmailWithAttachment(clan);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Your mail is sent to user."+clan.getEmail();
	}
}
