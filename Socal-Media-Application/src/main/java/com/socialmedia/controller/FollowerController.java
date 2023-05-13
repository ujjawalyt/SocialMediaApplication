package com.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.exceptions.FollowerNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.service.FollowerService;

@RestController
@RequestMapping("/follower")
public class FollowerController {

	@Autowired
	private FollowerService followerService;
	
	@PostMapping("/user/{userId}")
	public ResponseEntity<String> addNewFollowerToUser(@PathVariable("userId") Integer userId) throws UserNotFoundException{
		
		return new ResponseEntity<String>(followerService.addFollowerToUser(userId),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/user/{userId}/follower/{followerId}")
	public ResponseEntity<String> removeFollowerFromUser(@PathVariable("userId") Integer userId ,@PathVariable("followerId") Integer followerId ) 
			throws UserNotFoundException , FollowerNotFoundException{
		
		return new ResponseEntity<String>(followerService.removeFollowerFromUser(userId, followerId),HttpStatus.CREATED);
	}
	
}
