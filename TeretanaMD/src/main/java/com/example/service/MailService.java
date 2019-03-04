package com.example.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.domain.User;


@Service
public class MailService {
	
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(User user) throws MailException {
	
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmail());
		mail.setFrom("dm2005ss@gmail.com");
		mail.setSubject("Testing Mail API");
		mail.setText("Hurray ! radiii...");
		
		javaMailSender.send(mail);
	}

	public void sendEmailWithAttachment(User user) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(user.getEmail());
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Please find the attached document below.");

		FileSystemResource file = new FileSystemResource("/home/rockhard/Desktop/Registration.pdf");
		helper.addAttachment(file.getFilename(), file);

		javaMailSender.send(message);
	}

}
