package com.gis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gis.entity.AccountEntity;

public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {

}
