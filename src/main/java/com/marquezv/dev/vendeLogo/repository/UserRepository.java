package com.marquezv.dev.vendeLogo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import com.marquezv.dev.vendeLogo.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public Optional<UserEntity> findByEmail(String login);
	
	public User findByUsername(String username);
	
}
