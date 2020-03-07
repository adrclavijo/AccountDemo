package com.agalvez.account.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.agalvez.account.dto.TransferDTO;
import com.agalvez.account.dto.TransferResponseDTO;
import com.agalvez.account.entities.Account;

public interface IAccountService {
	
	/**
	 * Recovers an Account by his ID
	 * @param {@link Long} id
	 * @return {@link Account}
	 * @throws Exception
	 */
	public Account getAccount(Long id) throws Exception;
	
	/**
	 * Recovers an Account by his name
	 * @param {@link String} name
	 * @return {@link Account}
	 * @throws Exception
	 */
	public Account findAccount(String name) throws Exception;
	
	/**
	 * Recovers all Accounts
	 * @param {@link Pageable} page
	 * @return {@link Page} of {@link Account}
	 * @throws Exception
	 */
	public Page<Account> getAllAccounts(Pageable page) throws Exception;
	
	/**
	 * Creates a new Account
	 * @param {@link Account} account
	 * @return {@link Account}
	 * @throws Exception
	 */
	public Account createAccount(Account account) throws Exception;
	
	/**
	 * Allows to transfer money from one account to another
	 * @param {@link TransferDTO} transfer
	 * @return {@link TransferResponseDTO}
	 * @throws Exception
	 */
	public TransferResponseDTO transfer(TransferDTO transfer) throws Exception;

}
