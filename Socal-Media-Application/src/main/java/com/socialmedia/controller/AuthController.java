package com.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.dto.UserDto;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/socialMedia/")
public class AuthController {

	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register/users")
	public ResponseEntity<UserDto> registerAsUser(@RequestBody UserDto userDto) 
			throws UserNotFoundException{
		
		return new ResponseEntity<UserDto>(userService.addNewUser(userDto),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/register/admin")
	public ResponseEntity<UserDto> registerAsAdmin(@RequestBody UserDto userDto) 
			throws UserNotFoundException{
		
		return new ResponseEntity<UserDto>(userService.addNewAdmin(userDto),HttpStatus.CREATED);
	}
	
	
}
