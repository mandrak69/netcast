package com.example.wheather.security;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.wheather.dao.UserDao;
import com.example.wheather.entity.User;

import com.example.wheather.exception.UnauthorisedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {

	UserDao userDao;

	public static final String KEY = "2456D";

	@Autowired
	public LoginService(UserDao userDAO) {

		userDao = userDAO;
	}

	public String authorize(User us) {
		User user = userDao.findByEMailAndPassword(us.geteMail(), us.getPassword());

		if (user != null) {

			String jws = Jwts.builder().setIssuer(user.getFirstname()).setSubject(user.geteMail())
					.claim("name", user.getFirstname() + "" + user.getSurname())
					.setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L))).signWith(SignatureAlgorithm.HS256, KEY)
					.compact();
			return jws;
		}
		return null;

	}

	public String getUserEmail(@RequestParam String token) {
		Jws<Claims> jws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);

		return jws.getBody().getSubject();
	}

	public boolean chekToken(String token) {
		String userEmail = this.getUserEmail(token);

		return userEmail != null;
	}

}
