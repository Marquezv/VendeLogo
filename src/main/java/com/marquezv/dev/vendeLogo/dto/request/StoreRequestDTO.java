package com.marquezv.dev.vendeLogo.dto.request;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marquezv.dev.vendeLogo.entities.StoreEntity;
import com.marquezv.dev.vendeLogo.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequestDTO {
	
	private Long user_id;
	
	private String user_username;
	
	private String storeName;
	
	private Timestamp created_on;
	
	private Integer status;
	
	@JsonIgnore
	private UserEntity userEntity;
	
	public StoreEntity build() {
		StoreEntity store = new StoreEntity()
				.setStoreName(this.storeName)
				.setUserEnity(this.userEntity)
				.setCreated_on(this.created_on)
				.setStatus(this.status);
		return store;
	}
	
	public StoreRequestDTO toDTO(StoreEntity storeEntity) {
		StoreRequestDTO store = new StoreRequestDTO()
				.setUser_id(storeEntity.getUserEnity().getId())
				.setUser_username(storeEntity.getUserEnity().getUsername())
				.setStoreName(storeEntity.getStoreName())
				.setCreated_on(storeEntity.getCreated_on())
				.setStatus(storeEntity.getStatus());
		return store;
				
	}
}
