package com.agalvez.account.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.agalvez.account.repositories.AccountRepository;

@RunWith(SpringRunner.class)
public class AccountServiceImplTest {	
	
	@Mock
	private AccountRepository mockAccountRepository;
	
	@InjectMocks
	AccountServiceImpl accountService;
	
	@Test
	public void test() throws Exception {
		accountService.getAccount(1L);
	}
	

}
