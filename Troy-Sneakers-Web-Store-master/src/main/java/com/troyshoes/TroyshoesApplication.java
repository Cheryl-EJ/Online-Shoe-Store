package com.troyshoes;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.troyshoes.domain.User;
import com.troyshoes.domain.security.Role;
import com.troyshoes.domain.security.UserRole;
import com.troyshoes.service.UserService;
import com.troyshoes.utility.SecurityUtility;

@SpringBootApplication
public class TroyshoesApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(TroyshoesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstname("Jiarui");
		user1.setLastname("Jiang");
		user1.setUsername("oliver");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("jiangj8@rpi.edu");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}

}
