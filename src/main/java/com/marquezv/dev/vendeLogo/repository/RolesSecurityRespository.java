package com.marquezv.dev.vendeLogo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marquezv.dev.vendeLogo.entities.RolesSecurity;

public interface RolesSecurityRespository extends JpaRepository<RolesSecurity, Long>{
	Optional<RolesSecurity> findByName(String name);
	
}
