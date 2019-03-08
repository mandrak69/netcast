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
	public void doFilter(final ServletRequest request,final ServletResponse response,final FilterChain chain)
			throws IOException, ServletException {
		
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;
		final String token = httpRequest.getHeader("token");

		if (httpRequest.getRequestURI().contains("operater/login")) {
			chain.doFilter(request, response);
			return;
		}
		if (httpRequest.getRequestURI().contains("jsondoc-ui.html")) {
			chain.doFilter(request, response);
			return;
		}
		if (httpRequest.getRequestURI().contains("/hello")) {
			chain.doFilter(request, response);
			return;
		}

		if (token != null && loginService.proveriToken(token)) {
			String operaterEmail = loginService.getOperaterEmail(token);
			request.setAttribute("operater_Email", operaterEmail);
			if (operaterEmail != null) {
				chain.doFilter(request, response);
				return;
			} else
				httpResponse.setStatus(401);
		} else
			httpResponse.setStatus(401);

	}
}
