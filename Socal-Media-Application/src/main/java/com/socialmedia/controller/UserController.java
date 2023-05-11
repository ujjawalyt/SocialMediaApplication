package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.dto.UserDto;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.repository.UsersRepo;
import com.socialmedia.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
 
	
	@GetMapping("/")
	public String welcome() {
		return "hello Welcome to my Spring Boot Class";
	}
	
	
	@GetMapping("/{userid}")
	public ResponseEntity<UserDto> getUserByIdHandler(@PathVariable("userid") Integer id)
			throws UserNotFoundException{
		
		return new ResponseEntity<UserDto>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<String> deteteUserByIdHandler(@PathVariable("userid") Integer id)
			throws UserNotFoundException{
		
		return new ResponseEntity<String>(userService.deleteUserById(id),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUserByIdHandler(@PathVariable("userid") Integer id ,@RequestBody UserDto userDto)
			throws UserNotFoundException{
		
		return new ResponseEntity<UserDto>(userService.updateUser(userDto, id),HttpStatus.OK);
	}
	
	
	@GetMapping("/alluser")
	public ResponseEntity<List<UserDto>> getAllUserHandler()
			throws UserNotFoundException{
		
		return new ResponseEntity<List<UserDto>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
}
