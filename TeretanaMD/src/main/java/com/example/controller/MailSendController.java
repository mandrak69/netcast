package com.example.controller;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ClanDAO;
import com.example.domain.Clan;
import com.example.service.ClanService;
import com.example.service.MailService;
import com.example.service.intf.ClanIF;

@RestController
@RequestMapping(path = "/mail")
public class MailSendController {

	@Autowired
	private MailService notificationService;
	
    @Autowired
	private ClanIF clanService;
	
	@Autowired
	private ClanDAO clanDao;
	
	@GetMapping("/send/{id}")
	@ApiMethod(description = "Get member ID for sending mail ")
	public @ApiResponseObject @ResponseBody String send(@Valid @RequestBody @PathVariable long id) {

	    
	
		Clan clan = clanService.findById(id);
		
		//radi probe setovana adresa ..
		if (clan!=null) {
			clan.setEmail("dm2005ss@gmail.com");
			

			try {
				notificationService.sendEmail(clan, "Tekst propratni uz mail");
			} catch (MailException mailException) {
				System.out.println(mailException);
			}
			return "Your mail sent to user." + clan.getEmail();
		}
		return "No member with id" + id;
	}

	
	
	
	
	@RequestMapping("/sendToWithAttach/{id}")
	public String sendWithAttachment(@Valid @RequestBody @PathVariable long id) throws MessagingException {
		Optional<Clan> clanOp = clanDao.findById(id);
		if (clanOp.isPresent()) {
			Clan clan = clanOp.get();

			try {
				notificationService.sendEmailWithAttachment(clan);
			} catch (MailException mailException) {
				System.out.println(mailException);
			}
			return "Your mail is sent to user." + clan.getEmail();
		}
		return null;
	}
}
