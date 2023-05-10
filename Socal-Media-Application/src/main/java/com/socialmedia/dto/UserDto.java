package com.socialmedia.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	
	
	private int userId;
	private String username;
	private String displayName;
	private String email;
	private String password;
	private String bio;
    private LocalDateTime createAt;
    
    private List<RoleDto>roles = new ArrayList();
    
    
}
