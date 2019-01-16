package com.seVen.online_food_ordering;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seVen.online_food_ordering.domains.User;
import com.seVen.online_food_ordering.security.Role;
import com.seVen.online_food_ordering.security.UserRole;
import com.seVen.online_food_ordering.services.UserService;
import com.seVen.online_food_ordering.utilities.SecurityUtility;

@SpringBootApplication
public class OnlineFoodOrderingApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodOrderingApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("Abebe");
		user1.setLastName("Tola");
		user1.setUsername("user");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("password"));
		user1.setEmail("user@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}
}
