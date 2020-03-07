package com.agalvez.account.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agalvez.account.entities.Account;
import com.agalvez.account.services.IAccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	Logger logger = LogManager.getLogger();

	@Autowired
	IAccountService accountService;

	@GetMapping("/get/{id}")
	public Account getAccount(@PathVariable("id") Long id) throws Exception {
		return accountService.getAccount(id);
	}
	
	@GetMapping("/getAll")
	public Page<Account> getAllAccounts(@RequestParam int page, @RequestParam int pageSize) throws Exception {
		return accountService.getAllAccounts(PageRequest.of(page, pageSize));
	}
	
	@GetMapping("/find/{name}")
	public Account getAccount(@PathVariable("name") String name) throws Exception {
		return accountService.findAccount(name);
	}
	
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) throws Exception {
		logger.info(account);
		return accountService.createAccount(account);		
	}
}
