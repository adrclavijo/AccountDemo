package com.agalvez.account.dto;

import com.agalvez.account.entities.Account;
import com.agalvez.account.enums.CurrencyEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransferResponseDTO {

	private Account originAccount;

	private Account destinationAccount;

	private CurrencyEnum currency;

	private Long amount;

}
