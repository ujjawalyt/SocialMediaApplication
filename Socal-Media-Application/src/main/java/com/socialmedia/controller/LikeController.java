package com.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.exceptions.LikeAlreadyExistsException;
import com.socialmedia.exceptions.LikeNotFoundException;
import com.socialmedia.exceptions.TweetsNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.service.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {

	@Autowired
	private LikeService likeService;
	
	@PostMapping("/addLike/user/{userId}/tweets/{tweetsId}")
	public ResponseEntity<String> addLikesToTweetsByUser(@PathVariable("userId") Integer userId,
			@PathVariable("tweetsId") Integer tweetsId) 
					throws UserNotFoundException,TweetsNotFoundException,LikeAlreadyExistsException{
		return new ResponseEntity<String>(likeService.addLikeToTweets(userId, tweetsId),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove/user/{userId}/like/{likeId}")
	public ResponseEntity<String> removeLikesToTweetsByUser(@PathVariable("userId") Integer userId,
			@PathVariable("likeId") Integer likeId) 
					throws UserNotFoundException,LikeNotFoundException{
		return new ResponseEntity<String>(likeService.removeLikeFromTweets(userId, likeId),HttpStatus.OK);
	}
	
}
