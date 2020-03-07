package com.agalvez.account.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agalvez.account.entities.Account;
import com.agalvez.account.enums.CurrencyEnum;
import com.agalvez.account.services.IAccountService;

@RestController
@RequestMapping("/account")
public class AcountController {

	@Autowired
	IAccountService accountService;

	@GetMapping("/get/{id}")
	public Account getAccount(Long id) {

		Account test = new Account();
		test.setAccountId(1L);
		test.setCurrency(CurrencyEnum.EUR);
		test.setBalance(11L);
		test.setTreasury(false);
		
		return test;
	}

}
