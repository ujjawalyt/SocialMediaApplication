package com.socialmedia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.socialmedia.dto.UserDto;
import com.socialmedia.exceptions.UserNotFoundException;

@Service
public interface UserService {

	
	public UserDto addNewUser(UserDto userDto) throws UserNotFoundException;
	public UserDto addNewAdmin(UserDto userDto) throws UserNotFoundException;
	
	public UserDto updateUser(UserDto userDto ,Integer id)throws UserNotFoundException;
	public UserDto getUserById(Integer id)throws UserNotFoundException;
	public String deleteUserById(Integer id)throws UserNotFoundException;
	public List<UserDto> getAllUsers()throws UserNotFoundException;
	
	
}
