package com.socialmedia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.socialmedia.dto.TweetsDto;
import com.socialmedia.entity.TweetsResponse;
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
	
	public List<TweetsDto> findByContentKey(String keyword);
	
	public TweetsResponse getTweetsbyUser(Integer id)throws UserNotFoundException;
	
	public TweetsResponse getTweetsbyUser(Integer id, Integer pageNumber, Integer pageSize )throws UserNotFoundException;
			
	
}
