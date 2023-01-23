package com.ashar.fakebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashar.fakebook.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findRoleByRoleName(String name);
	
}
