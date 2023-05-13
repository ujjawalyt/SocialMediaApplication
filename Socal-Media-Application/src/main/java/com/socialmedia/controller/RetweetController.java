package com.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.exceptions.RetweetAlreadyExistsException;
import com.socialmedia.exceptions.RetweetNotFoundException;
import com.socialmedia.exceptions.TweetsNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.repository.RetweetRepo;
import com.socialmedia.service.RetweetService;

@RestController
@RequestMapping("/retweet")
public class RetweetController {

	@Autowired
	private RetweetService retweetService;
	
	@PostMapping("/user/{userId}/tweet/{tweetId}")
	public ResponseEntity<String> retweetByUser(@PathVariable("userId") Integer userId, @PathVariable("tweetId") Integer tweetId )
	throws UserNotFoundException, TweetsNotFoundException, RetweetAlreadyExistsException{
		
		return new ResponseEntity<String>(retweetService.retweetsByUser(userId, tweetId),HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/user/{userId}/retweet/{retweetId}")
	public ResponseEntity<String> removeRetweetByUser(@PathVariable("userId") Integer userId, @PathVariable("retweetId") Integer retweetId )
	throws UserNotFoundException,RetweetNotFoundException {
		
		return new ResponseEntity<String>(retweetService.removeRetweetsFromUser(userId, retweetId),HttpStatus.OK);
		
	}
	
	
}
