package com.gis.restcontroller;

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
import com.gis.service.AccountService;

@RestController
public class AccountRestController {

	@Autowired
	AccountService accountService;

	@PostMapping("/createAccount")
	public ResponseEntity<String> createAccount(@RequestBody AccountDto accountDto) {
		boolean accountStatus = accountService.createAccount(accountDto);
		if (accountStatus) {
			return new ResponseEntity<String>("Account created Successfully...", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Account created Successfully...", HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/updateAccount")
	public ResponseEntity<String> updateAccount(@RequestBody AccountDto accountDto) {
		boolean updateAccountDts = accountService.updateAccountDts(accountDto);
		if (updateAccountDts) {
			return new ResponseEntity<String>("updated success...", HttpStatus.OK);
		}
		return new ResponseEntity<String>("something went wrong...", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAccount/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Integer id) {
		AccountDto accountById = accountService.getAccountById(id);
		return new ResponseEntity<AccountDto>(accountById, HttpStatus.OK);
	}

	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<AccountDto>> getAllAccount() {
		List<AccountDto> allAccount = accountService.getAllAccount();
		return new ResponseEntity<List<AccountDto>>(allAccount, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<String> deleteAccountById(@PathVariable Integer id) {
		boolean deleteAccountById = accountService.deleteAccountById(id);
		if (deleteAccountById) {
			return new ResponseEntity<String>("Account is deleted...", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Some thing went wrong", HttpStatus.BAD_REQUEST);
	}
}
