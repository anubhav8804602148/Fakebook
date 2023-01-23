package com.ashar.fakebook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ashar.fakebook.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findUserByUsername(String username);
	public User findUserById(long id);
	public User findUserByEmail(String email);
	public User findUserByAccountId(long id);
	public List<User> findUserByFname(String name);
	
}
