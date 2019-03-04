package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.intf.UserIF;




@RestController
@RequestMapping("/secure")
public class SecureController {

	@Autowired
	private UserIF userService;

	@RequestMapping("/user/users")
	public String loginSuccess() {
		return "Login Successful!";
	}

	@PostMapping(value = "/user/email")
	public User findByEmail(@RequestBody String email) {
		return userService.findByEmail(email);
	}

	@PostMapping(value = "/user/update")
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}
}
