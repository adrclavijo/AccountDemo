package com.agalvez.account.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.agalvez.account.enums.CurrencyEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransferDTO {
	
	@NotNull
	private Long originAccountId;
	
	@NotNull
	private Long destinationAccountId;
	
	@NotNull
	private CurrencyEnum currency;
	
	@NotNull
	@Min(0)
	private Long amount;

}
