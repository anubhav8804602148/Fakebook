package com.ashar.fakebook.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ashar.fakebook.entities.CustomUserDetails;
import com.ashar.fakebook.repositories.UserRepository;

public class CustomUserServiceImplementation implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails userDetails = new CustomUserDetails(userRepository.findUserByUsername(username));
		return userDetails;
	}

}
