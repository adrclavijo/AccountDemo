package com.agalvez.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agalvez.account.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
