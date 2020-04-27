package com.troyshoes.service;

import java.util.Set;

import com.troyshoes.domain.User;
import com.troyshoes.domain.UserBilling;
import com.troyshoes.domain.UserPayment;
import com.troyshoes.domain.UserShipping;
import com.troyshoes.domain.security.PasswordResetToken;
import com.troyshoes.domain.security.UserRole;

public interface UserService {
	
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User createUser(User user, Set<UserRole> userRoles);
	
	User save(User user);
	
	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	void updateUserShipping(UserShipping userShipping, User user);
	
	void setUserDefaultPayment(Long userPaymentId, User user);
	
	void setUserDefaultShipping(Long userShippingId, User user);
}
