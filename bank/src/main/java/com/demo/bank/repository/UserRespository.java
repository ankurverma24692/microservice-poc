package com.demo.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.bank.dto.LoginRequest;
import com.demo.bank.entity.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {

	@Query("SELECT U FROM User U WHERE U.username = :userN")
	public List<User> searchUserByUserName(@Param("userN") String username);
}
