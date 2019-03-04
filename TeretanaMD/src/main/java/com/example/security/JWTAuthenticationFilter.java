package com.example.security;

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
public class JWTAuthenticationFilter implements javax.servlet.Filter {
	@Autowired
	LoginService loginService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String token=httpRequest.getHeader("token");
		
		if(httpRequest.getRequestURI().contains("operater/login")) {
			chain.doFilter(request, response);
			return;
		}
			if(httpRequest.getRequestURI().contains("jsondoc-ui.html")) {
				chain.doFilter(request, response);
				return;	
		}
		if(token != null && loginService.proveriToken(token)) {
		String operaterEmail = loginService.getOperaterEmail(token);
		
		if(operaterEmail != null) {
			httpRequest.setAttribute("OPERATER_MAIL", operaterEmail);
			chain.doFilter(request, response);
			return;
		}
		else
			httpResponse.setStatus(401);
		}
	}
}
