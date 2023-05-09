package com.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socialmedia.dto.UserDto;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Repository
@RequestMapping("/socialMedia")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create/users")
	public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto userDto) 
			throws UserNotFoundException{
		
		return new ResponseEntity<UserDto>(userService.addNewUser(userDto),HttpStatus.CREATED);
	}
}
