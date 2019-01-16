package com.seVen.online_food_ordering.services;

import java.util.Set;

import com.seVen.online_food_ordering.domains.User;
import com.seVen.online_food_ordering.security.PasswordResetToken;
import com.seVen.online_food_ordering.security.UserRole;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
}
