package com.example.wheather.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wheather.entity.Subscription;
import com.example.wheather.entity.User;
import com.example.wheather.entity.dto.UserDto;
import com.example.wheather.inter.CityIF;
import com.example.wheather.inter.UserIF;
import com.example.wheather.security.LoginService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	CityIF cityIf;
	UserIF userIf;
	LoginService loginService;
	
	
	@Autowired
	public UserController(CityIF cityIf, UserIF userIf,LoginService loginService) {
		
		this.cityIf = cityIf;
		this.userIf = userIf;
		this.loginService=loginService;
	}

	
		@PostMapping("login")
		public String getJwt(@RequestBody User user) {
			return loginService.authorize(user);
		}


	
	@PostMapping("register")
	public User register(@RequestBody UserDto user) {
		return userIf.register(user);
	}
	@DeleteMapping("delete/{id}")
	public void deleteUser(@PathVariable(name="id") String id) {
		userIf.deleteUser(id);
	}
	
	
	@PostMapping("subscribe")
	public Subscription subscribe(@RequestBody Subscription subscription, HttpServletRequest httpServletRequest) {
		String email = (String) httpServletRequest.getAttribute("USER_MAIL");
		return userIf.subscribe(subscription, email);
	}
	@PutMapping("update")
	public User updateUser(@RequestBody User user) {
		return userIf.updateUser(user);
	}
	@PutMapping("subscribe/update")
	public Subscription updateSubscription(@RequestBody Subscription subscription, HttpServletRequest httpServletRequest) {
		String email = (String) httpServletRequest.getAttribute("USER_MAIL");
		return userIf.updateSub(subscription, email);
	}
	@RequestMapping("subscriptions")
	public List<Subscription> listUserSubscriptions(HttpServletRequest httpServletRequest){
		String email = (String) httpServletRequest.getAttribute("USER_MAIL");
		return userIf.listSubs(email);
	}
	@DeleteMapping("subscription/delete")
	public void deleteSub(@RequestBody Subscription subscription,HttpServletRequest httpServletRequest) {
		String email = (String) httpServletRequest.getAttribute("USER_MAIL");
		userIf.deleteSub(subscription, email);
	}
	
}
