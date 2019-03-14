package com.example.wheather.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailBodyBuilder {

	private TemplateEngine templateEngine;

	@Autowired
	public MailBodyBuilder(TemplateEngine templateEngine) {		
		this.templateEngine = templateEngine;
	}
	
	public String buildBody(String body) {
		Context context = new Context();
		context.setVariable("body", body);
		return templateEngine.process("MailBody", context);
	}
	
	
}
