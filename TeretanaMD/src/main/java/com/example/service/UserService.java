package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.intf.UserIF;



@Service
public class UserService implements UserIF {

	@Autowired
	private UserDao userDao;
	

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User save(User user) {
		return userDao.save(user);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
}
