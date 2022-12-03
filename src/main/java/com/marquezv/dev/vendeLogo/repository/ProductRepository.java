package com.marquezv.dev.vendeLogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marquezv.dev.vendeLogo.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
