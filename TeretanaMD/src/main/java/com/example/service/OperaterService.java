package com.example.service;

import java.util.List;

/*import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dao.OperaterDAO;
//import com.example.domain.KnjigaTreninga;
import com.example.domain.Operater;
import com.example.dto.OperaterDTO;
import com.example.service.intf.OperaterIF;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class OperaterService implements OperaterIF{
	@Autowired
	OperaterDAO operaterDao;
	
	
	
	
	public OperaterService() {
		super();
		// TODO Auto-generated constructor stub
	}

	
//	@Autowired
//	private KnjigaTreningaDAO knjigaTreningaDAO;
	
	
	
	
	public Operater findByEmail(String email) {
		return operaterDao.findByEmail(email);	
	}
	
	
	public Operater kreirajOperatera(Operater operater) {
		operaterDao.save(operater);
		return operater;
	}


	@Override
	public List<Operater> findAll() {
		// TODO Auto-generated method stub
		return operaterDao.findAll();
	}


	@Override
	public OperaterDTO save(OperaterDTO clandto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Operater findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public OperaterDTO update(Long id, OperaterDTO clandto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Operater> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
//	public String login(Operater login) throws ServletException {
//
//	    String jwtToken = "";
//	    
//	    if (login.getEmail() == null || login.getPassword() == null) {
//	        throw new ServletException("Please fill in username and password");
//	    }
//	    
//	    String email = login.getEmail();
//	    String password = login.getPassword();
//	    
//		Operater operater = operaterDAO.findByEmail(email);
//
//	    if (operater == null) {
//	        throw new ServletException("User email not found.");
//	    }
//
//	    String pwd = operater.getPassword();
//
//	    if (!password.equals(pwd)) {
//	        throw new ServletException("Invalid login. Please check your name and password.");
//	    }
//
//	    jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
//	            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
//	    
//	    return jwtToken;
//	}
}
