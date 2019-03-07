package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MailService;



@RestController
@RequestMapping(value = "/mailFeedback", method = RequestMethod.GET)
public class MailController {
	// Provereno je preko mailtrap.io
	@Autowired
	private MailService mailService;
	
	
}
