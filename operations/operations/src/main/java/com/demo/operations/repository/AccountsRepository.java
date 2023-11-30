package com.demo.operations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.operations.entity.Accounts;

@Repository
public interface AccountsRepository  extends JpaRepository<Accounts, Long> {

}
