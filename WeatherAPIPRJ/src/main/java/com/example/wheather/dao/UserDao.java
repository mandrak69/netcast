package com.example.wheather.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wheather.entity.User;

public interface UserDao extends MongoRepository<User, String> {
	
	public User findByEMailAndPassword(String eMail, String password);
	
	public User findByEMail(String email);
	
}
