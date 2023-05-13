package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.entity.Retweets;
import com.socialmedia.entity.Tweets;
import com.socialmedia.entity.Users;
import com.socialmedia.exceptions.LikeAlreadyExistsException;
import com.socialmedia.exceptions.RetweetAlreadyExistsException;
import com.socialmedia.exceptions.RetweetNotFoundException;
import com.socialmedia.exceptions.TweetsNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.repository.RetweetRepo;
import com.socialmedia.repository.TweetsRepo;
import com.socialmedia.repository.UsersRepo;

@Service
public class RetweetServiceImpl implements RetweetService {

	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private RetweetRepo retweetRepo;
	
	@Autowired
	private TweetsRepo tweetsRepo;

	@Override
	public String retweetsByUser(Integer userId, Integer tweetId)
			throws UserNotFoundException, TweetsNotFoundException ,RetweetAlreadyExistsException{
		
		Users users = usersRepo.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("user not found with this userid" + userId));
		
		Tweets tweet = tweetsRepo.findById(tweetId)
			    .orElseThrow(() -> new TweetsNotFoundException("Tweet not found with ID: " + tweetId));
		
		
		boolean alreadyLiked = retweetRepo.existsByUsersAndTweets(users, tweet);
		if (alreadyLiked) {
			throw new RetweetAlreadyExistsException("User with ID " + userId + " has already Retweet tweet with ID " + tweetId);
		}
		Retweets retweets = new Retweets();
		
		retweets.setTweets(tweet);
		retweets.setUsers(users);
		
		retweetRepo.save(retweets);
		
		return "user Retweet the tweet..";
		
		
	}

	@Override
	public String removeRetweetsFromUser(Integer userId, Integer retweetId)
			throws UserNotFoundException, RetweetNotFoundException {
		
		Users users = usersRepo.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("user not found with this userid" + userId));
		
		Retweets retweets = retweetRepo.findById(retweetId)
				.orElseThrow(()-> new RetweetNotFoundException("retweet not found with this retweetId " + retweetId));
		
		if(! ( retweets.getUsers().getUserId() == userId)) {
			throw new RetweetNotFoundException("Retweet not found for the specified user ID and like ID." + userId);
		}
		
		retweetRepo.deleteById(retweetId);
		return "Retweet removed Successfully..!";
		
	}
	
	
	
	
}
