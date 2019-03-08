package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.example.dao.ClanDAO;
import com.example.dao.KnjigaTreningaDAO;
import com.example.domain.Clan;
import com.example.domain.KnjigaTreninga;
import com.example.dto.KnjigaTreningaClanaDTO;
import com.example.service.intf.KnjigaTreningaIF;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	ClanDAO clanDao;
	@Autowired
	KnjigaTreningaDAO knjigaTreningaDao;
	@Autowired
	KnjigaTreningaService knjigaTreningaService;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(Clan clan, String poruka) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo(clan.getEmail());
		mail.setFrom("dm2005ss@gmail.com");
		mail.setSubject("Vas mesecni izvestaj");
		mail.setText(poruka);

		javaMailSender.send(mail);
	}

	public void sendEmailMonthlyReport( String poruka) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo("dm2005ss@gmail.com");
		helper.setSubject("Vas mesecni izvestaj");

		helper.setText("Dokument u dodatku");
		HashMap<Long, Double> lista = knjigaTreningaService.getObracunClanBetween(1);

		List<Clan> clanovi = (List<Clan>) clanDao.findAll();
		for (Clan cln : clanovi) {
			Double dugovanje = lista.get(cln.getId());

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("teretane@gmail.com");
			mailMessage.setTo(cln.getEmail());
			mailMessage.setSubject("Nova poruka od teretane");
			mailMessage.setText(" Vasi dugovanje  trenutno je " + dugovanje);

			javaMailSender.send(mailMessage);

		}
	}

	public void sendEmailWithAttachment(Clan clan) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(clan.getEmail());
		helper.setSubject("Poruka sa prikacenim fajlom - reklama");

		helper.setText("Please find the attached document below.");

		FileSystemResource file = new FileSystemResource("/home/Registration.pdf");
		helper.addAttachment(file.getFilename(), file);

		javaMailSender.send(message);
	}

}
