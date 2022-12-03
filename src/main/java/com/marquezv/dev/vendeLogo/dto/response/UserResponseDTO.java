package com.marquezv.dev.vendeLogo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@ToString
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
	
	private String username;
		
	private String email;
	
	private Integer profile;
	
	private Integer status;
}
