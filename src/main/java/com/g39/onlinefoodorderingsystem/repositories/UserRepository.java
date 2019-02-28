package com.g39.onlinefoodorderingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.g39.onlinefoodorderingsystem.security.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);
	
}