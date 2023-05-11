package com.socialmedia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.socialmedia.dto.TweetsDto;
import com.socialmedia.exceptions.TweetsNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;

@Service

public interface TweetService {

	
	public TweetsDto creatTweetsByUser(TweetsDto tweetsDto ,Integer userid) 
			throws UserNotFoundException,TweetsNotFoundException;
	public TweetsDto updateTweetsByUser(TweetsDto tweetsDto ,Integer userid, Integer tweetId)
			throws UserNotFoundException,TweetsNotFoundException;
	public TweetsDto getTweetByUser(Integer userid,Integer tweetId)
			throws UserNotFoundException,TweetsNotFoundException;
	public String deleteTweetByUser(Integer tweetId) 
			throws UserNotFoundException,TweetsNotFoundException;
	public List<TweetsDto> getAllTweets();
			
	
}
