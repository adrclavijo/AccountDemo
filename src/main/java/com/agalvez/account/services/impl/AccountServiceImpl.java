package com.agalvez.account.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agalvez.account.entities.Account;
import com.agalvez.account.repositories.AccountRepository;
import com.agalvez.account.services.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) throws Exception {
		if (account != null) {
			account.setAccountId(null);
			return accountRepository.save(account);
		} else {
			throw new Exception("Invalid account data");
		}
		
		
	}

}
