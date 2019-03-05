package com.example.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.MailService;




@RestController
public class RegistrationController {

	@Autowired
	private MailService notificationService;

	@Autowired
	private User user;

	
	@RequestMapping("send-mail")
	public String send() {

		
		user.setFirstName("Dragan");
		user.setLastName("Markovic");
		user.setEmail("dm2005ss@gmail.com");

		
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	
	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException {

		
		user.setFirstName("Dragan");
		user.setLastName("Markovic");
		user.setEmail("dm2005ss@gmail.com");
		
		try {
			notificationService.sendEmailWithAttachment(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "jupiiii! Your mail has been send to the user.";
	}
}
