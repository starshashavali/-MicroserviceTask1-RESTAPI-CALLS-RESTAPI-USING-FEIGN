package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gis.dto.AccountDto;
import com.gis.feign.IAxisBankFeignClient;

@Service
public class AccountServiceImpl {
	@Autowired
	IAxisBankFeignClient iAxisBankFeignClient;

	public boolean createAccount(AccountDto accountDto) {
		ResponseEntity<String> createAccount = iAxisBankFeignClient.createAccount(accountDto);
		return true;
	}
	
	public String updateAccountDts(AccountDto accountDto) {
		ResponseEntity<String> updateAccount = iAxisBankFeignClient.updateAccount(accountDto);
		String body = updateAccount.getBody();
		return  body;
	}

	public AccountDto getdata(Integer id) {
		ResponseEntity<AccountDto> accountById = iAxisBankFeignClient.getAccountById(id);
		AccountDto body = accountById.getBody();
		return body;

	}

	public List<AccountDto> getAllAccounts() {
		ResponseEntity<List<AccountDto>> allAccount = iAxisBankFeignClient.getAllAccount();
		List<AccountDto> dto = allAccount.getBody();
		return dto;
	}

	public boolean deleteAxisBankAccount(Integer id) {
		ResponseEntity<String> deleteAccountById = iAxisBankFeignClient.deleteAccountById(id);
		return true;
	}

}
