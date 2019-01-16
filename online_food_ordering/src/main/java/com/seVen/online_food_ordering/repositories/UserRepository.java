package com.seVen.online_food_ordering.repositories;

import org.springframework.data.repository.CrudRepository;

import com.seVen.online_food_ordering.domains.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
	User findByEmail(String email);
}
