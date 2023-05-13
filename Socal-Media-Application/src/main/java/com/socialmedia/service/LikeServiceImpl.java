package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.entity.Likes;
import com.socialmedia.entity.Tweets;
import com.socialmedia.entity.Users;
import com.socialmedia.exceptions.LikeAlreadyExistsException;
import com.socialmedia.exceptions.LikeNotFoundException;
import com.socialmedia.exceptions.TweetsNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.repository.LikeRepo;
import com.socialmedia.repository.TweetsRepo;
import com.socialmedia.repository.UsersRepo;

@Service
public class LikeServiceImpl  implements LikeService{

	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private TweetsRepo tweetsRepo;
	@Autowired 
	private LikeRepo likeRepo;
	
	
	@Override
	public String addLikeToTweets(Integer userId, Integer tweetId)
			throws UserNotFoundException, TweetsNotFoundException, LikeAlreadyExistsException {
		Users users = usersRepo.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found with user ID : " +userId));
	    
		Tweets tweets = tweetsRepo.findById(tweetId)
				.orElseThrow(()-> new TweetsNotFoundException("tweets not found with tweet ID : "+ tweetId));
		
		// Check if the user has already liked the tweet
		boolean alreadyLiked = likeRepo.existsByUsersAndTweets(users, tweets);
		if (alreadyLiked) {
			throw new LikeAlreadyExistsException("User with ID " + userId + " has already liked tweet with ID " + tweetId);
		}
		
		Likes likes = new Likes();
		likes.setUsers(users);
		likes.setTweets(tweets);
		likeRepo.save(likes);
		
		return "Likes Added To Tweets Successfully..";
		
		
	}
	@Override
	public String removeLikeFromTweets(Integer userId, Integer likeId)
			throws UserNotFoundException, LikeNotFoundException {
		
		Users users = usersRepo.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found with user ID : " +userId));
	   
		Likes likes = likeRepo.findById(likeId)
				.orElseThrow(()-> new LikeNotFoundException("Like not Found with this likeId : " + likeId));
		
		if (!(likes.getUsers().getUserId() == userId) ) {
			throw new LikeNotFoundException("Like not found for the specified user ID and like ID.");
		}
		
		likeRepo.deleteById(likeId);
		return "like Removed Successfully...";
	}
	
}
