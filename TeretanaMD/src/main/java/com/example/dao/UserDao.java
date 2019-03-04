package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.User;



@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User save(User user);

	User findByEmail(String email);
}
