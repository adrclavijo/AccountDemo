package com.agalvez.account.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.agalvez.account.dto.TransferDTO;
import com.agalvez.account.dto.TransferResponseDTO;
import com.agalvez.account.entities.Account;
import com.agalvez.account.exceptions.AccountBadRequestException;
import com.agalvez.account.exceptions.AccountForbiddenException;
import com.agalvez.account.exceptions.AccountNotFoundException;
import com.agalvez.account.repositories.AccountRepository;
import com.agalvez.account.services.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) throws Exception {
		if (null == account) {
			throw new AccountBadRequestException("Invalid account data");
		} else {
			account.setAccountId(null);
			return accountRepository.save(account);
		}
	}

	@Transactional
	@Override
	public Account getAccount(Long id) throws Exception {
		if (null == id) {
			throw new Exception("Invalid ID");
		} else {
			return accountRepository.findById(id)
					.orElseThrow(() -> new AccountNotFoundException("Account with ID " + id + " cannot be found"));
		}
	}

	@Override
	public Page<Account> getAllAccounts(Pageable page) throws Exception {
		return accountRepository.findAll(page);
	}

	@Override
	public Account findAccount(String name) throws Exception {
		if (null == name) {
			throw new AccountBadRequestException("Invalid account name value");
		} else {
			List<Account> accountList = accountRepository.findByName(name);
			if (accountList.isEmpty()) {
				throw new AccountNotFoundException("Account with name " + name + " cannot be found");
			} else {
				return accountList.get(0);
			}
		}
	}

	@Transactional
	@Override
	public TransferResponseDTO transfer(TransferDTO transfer) throws Exception {
		if (null == transfer) {
			throw new AccountBadRequestException("Invalid transfer data values");
		} else if (transfer.getOriginAccountId() != null
				&& transfer.getOriginAccountId().equals(transfer.getDestinationAccountId())) {
			throw new AccountBadRequestException("Both accounts are the same one");
		} else {
			Account origin = getAccount(transfer.getOriginAccountId());
			Account destination = getAccount(transfer.getDestinationAccountId());
			if (origin.getBalance() < transfer.getAmount() && !origin.isTreasury()) {
				throw new AccountForbiddenException("The origin account has not enough balance for this transfer");
			}
			// different currency check

			origin.setBalance(origin.getBalance() - transfer.getAmount());
			destination.setBalance(destination.getBalance() + transfer.getAmount());

			TransferResponseDTO response = new TransferResponseDTO();
			response.setAmount(transfer.getAmount());
			response.setCurrency(transfer.getCurrency());
			response.setOriginAccount(accountRepository.save(origin));
			response.setDestinationAccount(accountRepository.save(destination));

			return response;
		}
	}

}
