package com.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.dto.JwtAuthRequest;
import com.socialmedia.dto.UserDto;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.jwt.JwtTokenHelper;
import com.socialmedia.payload.JwtAuthResponse;
import com.socialmedia.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/socialMedia/auth")
public class AuthController {

	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request){
		
		this.authenticate(request.getUsername(),request.getPassword());
		UserDetails userDetails =	this.userDetailsService.loadUserByUsername(request.getUsername());
		String token =	this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
		
	}
	
	

   private void authenticate(String username, String password) {
  UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		this.authenticationManager.authenticate(authenticationToken);
		
	}







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
