package com.troyshoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.troyshoes.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
