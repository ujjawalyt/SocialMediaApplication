package com.socialmedia.service;

import org.springframework.stereotype.Service;

import com.socialmedia.exceptions.RetweetAlreadyExistsException;
import com.socialmedia.exceptions.RetweetNotFoundException;
import com.socialmedia.exceptions.TweetsNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;

@Service
public interface RetweetService {

	
	public String retweetsByUser(Integer userId, Integer tweetId) 
			throws UserNotFoundException,TweetsNotFoundException , RetweetAlreadyExistsException;
	
	public String removeRetweetsFromUser(Integer userId, Integer retweetId) 
			throws UserNotFoundException,RetweetNotFoundException;
}
