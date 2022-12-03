package com.marquezv.dev.vendeLogo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marquezv.dev.vendeLogo.commons.status.StatusUser;
import com.marquezv.dev.vendeLogo.dto.request.UserRequestDTO;
import com.marquezv.dev.vendeLogo.dto.response.UserResponseDTO;
import com.marquezv.dev.vendeLogo.entities.UserEntity;
import com.marquezv.dev.vendeLogo.repository.UserRepository;
import com.marquezv.dev.vendeLogo.service.exceptions.EntityNotFoundException;

@Service
public class UserService  {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public UserResponseDTO findById(Long id) {
		UserResponseDTO userResponse = new UserRequestDTO().toResponse(repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("[SERVICE_ERROR] ID_NOT_FOUND [ " + id + " ]")));
		return userResponse;
	}

	public List<UserResponseDTO> findAll() {
		List<UserResponseDTO> userResonseList = new ArrayList<UserResponseDTO>();
		for (UserEntity userEntity : repository.findAll()) {
			UserResponseDTO userResonse = new UserRequestDTO().toResponse(userEntity);
			userResonseList.add(userResonse);
		}
		return userResonseList;
	}
//	

	public void save(UserRequestDTO userDTO) {

		userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);
		userDTO.setCreated_on(timestamp);
		userDTO.setLast_login(timestamp);

		userDTO.setStatus(StatusUser.OFFLINE.ordinal());
		System.out.println(userDTO);
		repository.save(userDTO.build());
	}

	public Optional<UserEntity> findByIdEntity(Long id) {
		return repository.findById(id);
	}

}
