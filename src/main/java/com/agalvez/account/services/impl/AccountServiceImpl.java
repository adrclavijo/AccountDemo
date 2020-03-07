package com.agalvez.account.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agalvez.account.entities.Account;
import com.agalvez.account.exceptions.AccountBadRequestException;
import com.agalvez.account.exceptions.AccountNotFoundException;
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
			throw new AccountBadRequestException("Invalid account data");
		}

	}

	@Transactional
	@Override
	public Account getAccount(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Invalid ID");
		} else {
			return accountRepository.findById(id)
					.orElseThrow(() -> new AccountNotFoundException("Account with ID " + id + " cannot be found"));
		}
	}

}
