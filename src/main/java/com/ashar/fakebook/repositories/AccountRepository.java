package com.ashar.fakebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashar.fakebook.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public Account findAccountById(long id);
}
