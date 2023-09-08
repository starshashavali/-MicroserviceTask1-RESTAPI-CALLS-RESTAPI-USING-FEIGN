package com.gis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gis.dto.AccountDto;
import com.gis.entity.AccountEntity;
import com.gis.repo.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public boolean updateAccountDts(AccountDto accountDto) {
		Optional<AccountEntity> findById = accountRepo.findById(accountDto.getAccountId());
		if (findById.isPresent()) {
			AccountEntity accountEntity = findById.get();
			BeanUtils.copyProperties(accountDto, accountEntity);
			accountRepo.save(accountEntity);
			return true;
		}

		return false;
	}

	@Override
	public boolean createAccount(AccountDto accountDto) {

		AccountEntity entity = new AccountEntity();

		BeanUtils.copyProperties(accountDto, entity);

		accountRepo.save(entity);

		return true;
	}

	@Override
	public AccountDto getAccountById(Integer id) {
		Optional<AccountEntity> findById = accountRepo.findById(id);
		if (findById.isPresent()) {
			AccountEntity accountEntity = findById.get();
			AccountDto dto = new AccountDto();
			BeanUtils.copyProperties(accountEntity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<AccountDto> getAllAccount() {
		List<AccountEntity> findAll = accountRepo.findAll();
		List<AccountDto> allDto = new ArrayList<>();
		for (AccountEntity entity : findAll) {
			AccountDto dto = new AccountDto();
			BeanUtils.copyProperties(entity, dto);
			allDto.add(dto);
		}
		return allDto;
	}

	@Override
	public boolean deleteAccountById(Integer id) {
		accountRepo.deleteById(id);
		return true;
	}

}
