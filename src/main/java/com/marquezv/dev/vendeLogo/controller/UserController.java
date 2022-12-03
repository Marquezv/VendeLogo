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

import com.marquezv.dev.vendeLogo.dto.request.UserRequestDTO;
import com.marquezv.dev.vendeLogo.dto.response.UserResponseDTO;
import com.marquezv.dev.vendeLogo.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(userService.findById(id));
	}
	
	@PostMapping
	public void insert(@RequestBody UserRequestDTO userDTO) {
		userService.save(userDTO);
	}
	
	
}
