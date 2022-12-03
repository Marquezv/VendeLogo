package com.marquezv.dev.vendeLogo.dto.request;

import java.sql.Timestamp;

import com.marquezv.dev.vendeLogo.dto.response.UserResponseDTO;
import com.marquezv.dev.vendeLogo.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
	
	private String username;
	
	private String email;
	
	private String password;
	
	private Integer profile;
	
	private Integer status;
	
	private Timestamp created_on;
	
	private Timestamp last_login;

	public UserEntity build() {
		UserEntity user = new UserEntity()
				.setUsername(this.username)
				.setEmail(this.email)
				.setPassword(this.password)
				.setProfile(this.profile)
				.setStatus(this.status)
				.setCreated_on(this.created_on)
				.setLast_login(this.last_login);
		return user;
	}
	
	
	public UserResponseDTO toResponse(UserEntity userEntity) {
		UserResponseDTO user = new UserResponseDTO()
				.setUsername(userEntity.getUsername())
				.setEmail(userEntity.getEmail())
				.setProfile(userEntity.getProfile())
				.setStatus(userEntity.getProfile());
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
