package com.gis.service;

import java.util.List;

import com.gis.dto.AccountDto;


public interface AccountService {

	public boolean createAccount(AccountDto accountDto);
	
	public boolean updateAccountDts(AccountDto accountDto);

	public AccountDto getAccountById(Integer id);

	public List<AccountDto> getAllAccount();
	
	public boolean deleteAccountById(Integer id);

}
