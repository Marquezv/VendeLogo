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

import com.marquezv.dev.vendeLogo.dto.request.StoreRequestDTO;
import com.marquezv.dev.vendeLogo.service.StoreService;

@RestController
@RequestMapping(value = "/store")
public class StoreController {
	
	
	@Autowired
	private StoreService storeService;
	
	
	@GetMapping
	public ResponseEntity<List<StoreRequestDTO>> findAll() {
		return ResponseEntity.ok().body(storeService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StoreRequestDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(storeService.findById(id));
	}

	@PostMapping
	public void insert(@RequestBody StoreRequestDTO storeDTO) throws Exception {
		storeService.save(storeDTO);
	}
}
