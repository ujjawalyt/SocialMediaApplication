package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.dto.TweetsDto;
import com.socialmedia.exceptions.TweetsNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.service.TweetService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

	@Autowired
	private TweetService tweetService;
	
	@PostMapping("/createtweet/{userid}")
	public ResponseEntity<TweetsDto> createTweetsByUser
	(@RequestBody TweetsDto tweetsDto , @PathVariable("userid") Integer id) 
			throws TweetsNotFoundException,UserNotFoundException{
		
		return new ResponseEntity<TweetsDto>(tweetService.creatTweetsByUser(tweetsDto, id),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updatetweet/{userid}/{tweetid}")
	public ResponseEntity<TweetsDto> updateTweetsByUser
	(@RequestBody TweetsDto tweetsDto , @PathVariable("userid") Integer userid, @PathVariable("tweetid") Integer tweetid) 
			throws TweetsNotFoundException,UserNotFoundException{
		
		return new ResponseEntity<TweetsDto>(tweetService.updateTweetsByUser(tweetsDto, userid, tweetid),HttpStatus.OK);
	}
	
	@GetMapping("/gettweet/{userid}/{tweetid}")
	public ResponseEntity<TweetsDto>getTweetsByUser
	(@PathVariable("userid") Integer userid, @PathVariable("tweetid") Integer tweetid) 
			throws TweetsNotFoundException,UserNotFoundException{
		
		return new ResponseEntity<TweetsDto>(tweetService.getTweetByUser(userid, tweetid),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletetweet/{tweetid}")
	public ResponseEntity<String>deleteTweetsByUser
	( @PathVariable("tweetid") Integer tweetid) 
			throws TweetsNotFoundException,UserNotFoundException{
		
		return new ResponseEntity<String>(tweetService.deleteTweetByUser(tweetid),HttpStatus.OK);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<TweetsDto>>getAllTweets() {
		
		return new ResponseEntity<List<TweetsDto>>(tweetService.getAllTweets(),HttpStatus.OK);
	}
	
	
	
	
}
