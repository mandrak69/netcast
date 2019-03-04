package com.example.service.intf;

import com.example.domain.User;

public interface UserIF {
	User save(User user);

	User findByEmail(String email);

}
