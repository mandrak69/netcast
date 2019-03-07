package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.example.dao.ClanDAO;
import com.example.dao.KnjigaTreningaDAO;
import com.example.domain.Clan;
import com.example.domain.KnjigaTreninga;
import com.example.dto.KnjigaTreningaClanaDTO;


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
	
	/*@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
*/
	
	
	public void sendEmail(Clan clan,String poruka) throws MailException {
	
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(clan.getEmail());
		mail.setFrom("dm2005ss@gmail.com");
		mail.setSubject("Vas mesecni izvestaj");
		mail.setText(poruka);
		
		javaMailSender.send(mail);
	}
	
	
	public void sendEmailMonthlyReport(Clan clan) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(clan.getEmail());
		helper.setSubject("Vas mesecni izvestaj");
		
		helper.setText("Please find the attached document below.");

		
		
		 List<Clan> clanovi = (List<Clan>) clanDao.findAll();
		for(Clan cln: clanovi) {
			List<KnjigaTreningaClanaDTO> spisakTreninga = new ArrayList<>();
			
	/*		
			List<KnjigaTreninga> lista = knjigaTreningaDao.findKnjigaTreningaByIdNamedParams(cln.getId());
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("");
			mailMessage.setTo(k.getEmail());
			mailMessage.setSubject("Nova poruka od teretane");
			mailMessage.setText(" Vasi mesecni pregledi su " +evidencija.toString());
			
			// Send email
			mailSender.send(mailMessage);
			
			
			
			
			
			

		javaMailSender.send(message);
		*/
	}
	}	
	public void sendEmailWithAttachment(Clan clan) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(clan.getEmail());
		helper.setSubject("Poruka sa prikacenim fajlom - reklama");
		
		helper.setText("Please find the attached document below.");

		FileSystemResource file = new FileSystemResource("/home/rockhard/Desktop/Registration.pdf");
		helper.addAttachment(file.getFilename(), file);

		javaMailSender.send(message);
	}

}
