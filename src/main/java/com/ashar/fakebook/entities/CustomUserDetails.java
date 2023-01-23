package com.ashar.fakebook.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{
	private static final long serialVersionUID = -2023480656587035357L;
	
	private User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authoritiesList = new ArrayList<>();
		user
			.getAccount()
			.getRoles()
			.stream()
			.forEach(role ->authoritiesList.addAll(role.getAuthorities()));
		return authoritiesList;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !user.getAccount().isExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.getAccount().isLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.getAccount().isExpired();
	}

	@Override
	public boolean isEnabled() {
		return !user.getAccount().isEnabled();
	}

}
