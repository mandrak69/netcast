package com.example.security;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.dao.OperaterDAO;
import com.example.domain.Operater;
import com.example.dto.OperaterDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {

	@Autowired
	OperaterDAO operaterDao;
	
	public static final String KEY = "1335A";

	
	public LoginService() {
		super();
		
	}

	
// provera autorizacije po prosledjenom objektu -email i password zahtevani
	
	public String authorize(OperaterDTO operaterDTO) {
		Operater operater=operaterDao.findByEmailAndPassword(operaterDTO.getEmail(), operaterDTO.getPassword());
		if(operater!=null) {
			String jws = Jwts.builder().setIssuer(operater.getIme())
					.setSubject(operater.getEmail())
					.claim("name", operater.getIme()+""+operater.getPrezime())
					.setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
					.signWith( SignatureAlgorithm.HS256,KEY).compact();
			return jws;
		}
		return null;
		
	}
	  
	public String getOperaterEmail(@RequestParam String token) {
		Jws<Claims> jws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
		
		return jws.getBody().getSubject() ;
	}
	
	
	public boolean proveriToken( String token) {
		String userEmail = this.getOperaterEmail(token);
		return userEmail != null;
	}
	
}
