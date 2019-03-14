package com.example.wheather.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Filter implements javax.servlet.Filter {

	LoginService loginService;

	@Autowired
	public Filter(LoginService loginService) {

		this.loginService = loginService;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String token = httpRequest.getHeader("token");

		if (httpRequest.getRequestURI().contains("user/login") || httpRequest.getRequestURI().contains("register")) {
			chain.doFilter(request, response);
			return;
		}

		else
		if (loginService.chekToken(token)) {
			String operaterEmail = loginService.getUserEmail(token);
		
			if (operaterEmail != null ) {
				httpRequest.setAttribute("USER_MAIL", operaterEmail);
				chain.doFilter(request, response);
				return;
			}
			
		}
		httpResponse.setStatus(401);
	}
}
