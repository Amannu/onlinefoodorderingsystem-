package com.g39.onlinefoodorderingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.g39.onlinefoodorderingsystem.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

	 Role findByRole(String role);
	 
}
