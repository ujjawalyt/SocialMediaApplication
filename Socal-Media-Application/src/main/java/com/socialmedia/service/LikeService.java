package com.socialmedia.service;

import org.springframework.stereotype.Service;

import com.socialmedia.exceptions.LikeAlreadyExistsException;
import com.socialmedia.exceptions.LikeNotFoundException;
import com.socialmedia.exceptions.TweetsNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;

@Service
public interface LikeService {

	public String addLikeToTweets(Integer userId, Integer tweetId)
			throws UserNotFoundException, TweetsNotFoundException, LikeAlreadyExistsException;
	public String removeLikeFromTweets(Integer userId, Integer likeId) 
			throws UserNotFoundException, LikeNotFoundException;
}
