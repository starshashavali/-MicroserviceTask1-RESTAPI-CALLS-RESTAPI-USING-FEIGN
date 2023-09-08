package com.tcs.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gis.dto.AccountDto;
import com.tcs.service.AccountServiceImpl;

@RestController
public class AccountRestController {
	@Autowired
	AccountServiceImpl accountServiceImpl;

	@PostMapping("/createAxis")
	public ResponseEntity<String> createAxisBank(@RequestBody AccountDto accountDto) {
		accountServiceImpl.createAccount(accountDto);
		return new ResponseEntity<String>("Account is created...", HttpStatus.CREATED);
	}

	@PutMapping("/updateAccount")
	public ResponseEntity<String> updateAccount(@RequestBody AccountDto accountDto) {
		String updateAccountDts = accountServiceImpl.updateAccountDts(accountDto);
		return new ResponseEntity<String>(updateAccountDts, HttpStatus.OK);
	}

	@GetMapping("/getAccountById/{id}")
	public ResponseEntity<AccountDto> getAccountId(@PathVariable Integer id) {
		AccountDto getdata = accountServiceImpl.getdata(id);
		return new ResponseEntity<AccountDto>(getdata, HttpStatus.OK);
	}

	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
		List<AccountDto> allAccounts = accountServiceImpl.getAllAccounts();
		return new ResponseEntity<List<AccountDto>>(allAccounts, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<String> deleteAxisBankAccount(@PathVariable Integer id) {
		boolean deleteStatus = accountServiceImpl.deleteAxisBankAccount(id);
		if (deleteStatus) {
			return new ResponseEntity<String>("Account is deleted...", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);

	}
}
