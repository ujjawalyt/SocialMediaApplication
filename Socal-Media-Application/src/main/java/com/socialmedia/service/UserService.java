package com.socialmedia.service;

import org.springframework.stereotype.Service;

import com.socialmedia.dto.UserDto;
import com.socialmedia.exceptions.UserNotFoundException;

@Service
public interface UserService {

	
	public UserDto addNewUser(UserDto userDto) throws UserNotFoundException;
}
