package com.agalvez.account.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.agalvez.account.entities.Account;

public interface IAccountService {
	
	public Account getAccount(Long id) throws Exception;
	
	public Account findAccount(String name) throws Exception;
	
	public Page<Account> getAllAccounts(Pageable page) throws Exception;
	
	public Account createAccount(Account account) throws Exception;

}
