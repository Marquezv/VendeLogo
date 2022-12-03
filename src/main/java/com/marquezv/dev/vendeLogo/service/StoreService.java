package com.marquezv.dev.vendeLogo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marquezv.dev.vendeLogo.commons.status.StatusStore;
import com.marquezv.dev.vendeLogo.dto.request.StoreRequestDTO;
import com.marquezv.dev.vendeLogo.entities.StoreEntity;
import com.marquezv.dev.vendeLogo.entities.UserEntity;
import com.marquezv.dev.vendeLogo.repository.StoreRepository;
import com.marquezv.dev.vendeLogo.service.exceptions.EntityNotFoundException;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository repository;
	
	@Autowired
	private UserService userService;
	
	public StoreRequestDTO findById(Long id) {
		StoreEntity storeEntity = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("[SERVICE_ERROR] ID_NOT_FOUND [ " + id + " ]"));
		StoreRequestDTO storeDTO = new StoreRequestDTO().toDTO(storeEntity);
		return storeDTO;
	}
	
	public List<StoreRequestDTO> findAll() {
		List<StoreRequestDTO> storeRequestList = new ArrayList<StoreRequestDTO>();
		for(StoreEntity storeEntity : repository.findAll()) {
			StoreRequestDTO storeRequest = new StoreRequestDTO()
					.toDTO(storeEntity);
			storeRequestList.add(storeRequest);
		}
		return storeRequestList;
	}
	public void save(StoreRequestDTO storeDTO) {
		
//		StoreEntity storeEntity = storeService.findByIdEntity(productDTO.getStore_Id()).orElseThrow(
//				() -> new EntityNotFoundException("[SERVICE_ERROR] ID_NOT_FOUND [ " + productDTO.getStore_Id() + " ]"));
		
		UserEntity userEntity = userService.findByIdEntity(storeDTO.getUser_id()).orElseThrow(
				() -> new EntityNotFoundException("[SERVICE_ERROR] USER_ID_NOT_FOUND [ " + storeDTO.getUser_id() + " ]"));
	
		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);
		storeDTO.setCreated_on(timestamp);
		storeDTO.setStatus(StatusStore.OFFLINE.ordinal());
		storeDTO.setUserEntity(userEntity);
		repository.save(storeDTO.build());
	}
	
	public Optional<StoreEntity> findByIdEntity(Long id) {
		return repository.findById(id);
	}
}
