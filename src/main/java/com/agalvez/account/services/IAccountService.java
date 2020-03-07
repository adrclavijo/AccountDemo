package com.agalvez.account.services;

import com.agalvez.account.entities.Account;

public interface IAccountService {
	
	public Account getAccount(Long id) throws Exception;
	
	public Account createAccount(Account account) throws Exception;

}
