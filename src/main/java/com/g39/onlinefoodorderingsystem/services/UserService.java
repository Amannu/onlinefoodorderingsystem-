package com.g39.onlinefoodorderingsystem.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.g39.onlinefoodorderingsystem.security.User;

public interface UserService extends UserDetailsService {

	User findUserByUsername(String username);
	void saveUser(User user);
	
}
