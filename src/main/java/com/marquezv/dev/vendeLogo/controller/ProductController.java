package com.marquezv.dev.vendeLogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marquezv.dev.vendeLogo.dto.request.ProductRequestDTO;
import com.marquezv.dev.vendeLogo.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping 
	public ResponseEntity<List<ProductRequestDTO>> findAll(){
		return ResponseEntity.ok().body(productService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductRequestDTO> findById(@PathVariable Long id) {
			return ResponseEntity.ok().body(productService.findById(id));
	}

	@PostMapping
	public void insert(@RequestBody ProductRequestDTO productDTO) {
		productService.save(productDTO);
	}
}
