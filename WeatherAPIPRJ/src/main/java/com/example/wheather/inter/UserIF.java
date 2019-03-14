package com.example.wheather.inter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.wheather.dao.UserDao;
import com.example.wheather.entity.Subscription;
import com.example.wheather.entity.User;
import com.example.wheather.entity.UserAndCitiesByType;
import com.example.wheather.entity.dto.EmailForecast;
import com.example.wheather.entity.dto.UserDto;
import com.example.wheather.scheduler.MailService;


public interface UserIF {



	public User register(UserDto user);
	
	public Subscription subscribe(Subscription subscription, String email);
	
	public List<UserAndCitiesByType> getTimeLists(int time);
	
	public List<EmailForecast> getBody(List<String> cities);
		
	public void deleteUser(String id);
	
	public User updateUser(User user);
	
	public Subscription updateSub(Subscription subscription, String email);
	
	public List<Subscription> listSubs(String email);
	
	public void deleteSub(Subscription sub, String email);

	public void sendbySub(int i, MailService mailService);
	
	
}
