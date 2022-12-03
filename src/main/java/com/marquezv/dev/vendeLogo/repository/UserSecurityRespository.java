package com.marquezv.dev.vendeLogo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marquezv.dev.vendeLogo.entities.UserSecurityEntity;

public interface UserSecurityRespository extends JpaRepository<UserSecurityEntity, Long> {

	Optional<UserSecurityEntity> findByUsername(String username);
	
	Boolean existsByUsername(String username);
}
