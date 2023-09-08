package com.gis.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gis.dto.AccountDto;


@FeignClient(name="STATEBANK-API")
public interface IAxisBankFeignClient {
	
	@PostMapping("/createAccount")
	public ResponseEntity<String> createAccount(@RequestBody AccountDto accountDto);
	
	@PutMapping("/updateAccount")
	public ResponseEntity<String> updateAccount(@RequestBody AccountDto accountDto);

	@GetMapping("/getAccount/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Integer id);
	
	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<AccountDto>> getAllAccount();
	
	@DeleteMapping("/deleteAccount/{id}")
	public  ResponseEntity<String> deleteAccountById(@PathVariable Integer id);
	
	
}
