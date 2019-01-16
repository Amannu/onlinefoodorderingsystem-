package com.seVen.online_food_ordering.repositories;

import org.springframework.data.repository.CrudRepository;

import com.seVen.online_food_ordering.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
