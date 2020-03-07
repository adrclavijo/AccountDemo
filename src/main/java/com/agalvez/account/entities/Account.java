package com.agalvez.account.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.agalvez.account.enums.CurrencyEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Account")
@Table(name = "ACCOUNT")
@Getter
@Setter
@ToString
public class Account implements Serializable {

	private static final long serialVersionUID = 3363261947234147285L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long accountId;

	@Column(length = 100)
	private String name;

	@Column(length = 3)
	@Enumerated(EnumType.STRING)
	private CurrencyEnum currency;

	@Column
	private Long balance;

	@Column
	private boolean treasury;

}
