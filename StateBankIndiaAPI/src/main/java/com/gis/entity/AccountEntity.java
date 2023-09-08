package com.gis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AccountEntity {
	@Id
	@GeneratedValue
	private Integer accountId;

	private String accountType;

	private String accountHolder;

}
