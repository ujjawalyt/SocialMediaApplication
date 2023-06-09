package com.socialmedia.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.socialmedia.dto.TweetsDto;
import com.socialmedia.dto.UserDto;
import com.socialmedia.entity.Tweets;
import com.socialmedia.entity.TweetsResponse;
import com.socialmedia.entity.Users;
import com.socialmedia.exceptions.TweetsNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.repository.TweetsRepo;
import com.socialmedia.repository.UsersRepo;

@Service
public class TweetServiceImpl implements TweetService{

	@Autowired
	private TweetsRepo tweetsRepo;
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public TweetsDto creatTweetsByUser(TweetsDto tweetsDto, Integer userid)
			throws UserNotFoundException, TweetsNotFoundException {
		
		 Users user = usersRepo.findById(userid)
		            .orElseThrow(() -> new UserNotFoundException("User not found with user ID: " +userid));
		    
		    
		    Tweets tweet = modelMapper.map(tweetsDto, Tweets.class);
		    tweet.setCreateAt(LocalDateTime.now());
		    tweet.setUsers(user);
		
		    Tweets savedTweet = tweetsRepo.save(tweet);   
		    
		    // Add the saved tweet to the user's list of tweets
		    user.getTweets().add(savedTweet);
		     
		    TweetsDto savedTweetDto  =  modelMapper.map(savedTweet, TweetsDto.class);
		    savedTweetDto.setUser(modelMapper.map(user, UserDto.class)); // Map the UserDto information
		    
		    return savedTweetDto;
	 
		
	}

	@Override
	public TweetsDto updateTweetsByUser(TweetsDto tweetsDto, Integer userid , Integer tweetId)
			throws UserNotFoundException, TweetsNotFoundException {
		
		Users user = usersRepo.findById(userid)
	            .orElseThrow(() -> new UserNotFoundException("User not found with user ID: " +userid));
		System.out.println(user.getDisplayName());
		
		Tweets tweet = tweetsRepo.findById(tweetId)
			    .orElseThrow(() -> new TweetsNotFoundException("Tweet not found with ID: " + tweetId));
		System.out.println(tweet.getTweetId());
				
//		 Tweets tweet = modelMapper.map(tweetsDto, Tweets.class);
		   tweet.setContent(tweetsDto.getContent());
		   tweet.setCreateAt(LocalDateTime.now());
		   Tweets savedTweet = tweetsRepo.save(tweet); 
		   user.getTweets().add(savedTweet);
		   
		   TweetsDto savedTweetDto  =  modelMapper.map(savedTweet, TweetsDto.class);
		    savedTweetDto.setUser(modelMapper.map(user, UserDto.class)); // Map the UserDto information
		    
		    return savedTweetDto;
		
		
	}

	@Override
	public TweetsDto getTweetByUser(Integer userid, Integer tweetId)
			throws UserNotFoundException, TweetsNotFoundException {
		
		Users user = usersRepo.findById(userid)
	            .orElseThrow(() -> new UserNotFoundException("User not found with user ID: " +userid));
		System.out.println(user.getDisplayName());
		
		Tweets tweet = tweetsRepo.findById(tweetId)
			    .orElseThrow(() -> new TweetsNotFoundException("Tweet not found with ID: " + tweetId));
		System.out.println(tweet.getTweetId());
		TweetsDto savedTweetDto  =  modelMapper.map(tweet, TweetsDto.class);
	    savedTweetDto.setUser(modelMapper.map(user, UserDto.class)); // Map the UserDto information
	    
	    return savedTweetDto;
		
	}

	@Override
	public String deleteTweetByUser(Integer tweetId) throws UserNotFoundException, TweetsNotFoundException {
		
		Tweets tweet = tweetsRepo.findById(tweetId)
	            .orElseThrow(() -> new TweetsNotFoundException("Tweet not found with ID: " + tweetId));
	    System.out.println(tweet.getTweetId());

	    tweet.setUsers(null);
	    tweetsRepo.deleteById(tweetId);

	    return "Tweet deleted successfully.";
	
	}

	@Override
	public List<TweetsDto> getAllTweets()  {
		
		List<Tweets> tweet = tweetsRepo.findAll();
		
		
	
		List<TweetsDto> list = tweet.stream()
	            .map(tweets -> {
	                TweetsDto tweetsDto = modelMapper.map(tweets, TweetsDto.class);

	               
	                UserDto userDto = modelMapper.map(tweets.getUsers(), UserDto.class);
	                tweetsDto.setUser(userDto);

	                return tweetsDto;
	            })
	            .collect(Collectors.toList());

	    return list;
		
		
		
		
	}

	@Override
	public List<TweetsDto> findByContentKey(String keyword) {
		
		List<Tweets> tweets = tweetsRepo.findByContentContainingIgnoreCase(keyword);
		
		List<TweetsDto> tweetsDtos = tweets.stream()
				.map((tweet)-> {
					 TweetsDto tweetsDto =	modelMapper.map(tweet, TweetsDto.class);
					 UserDto userDto = modelMapper.map(tweet.getUsers(), UserDto.class);
						tweetsDto.setUser(userDto);
					return tweetsDto;	
						
	}).collect(Collectors.toList());
		
		return tweetsDtos;
		
		
	}

	@Override
	public TweetsResponse getTweetsbyUser(Integer id) throws UserNotFoundException {
		
		
		Users users  = usersRepo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("Tweet not found with ID: " + id));
		
		List<Tweets> tweets = tweetsRepo.findByUsers(users);
		
		List<TweetsDto> tweetsDtos = tweets.stream()
				.map(post -> {
				TweetsDto tweetsDto =	modelMapper.map(post, TweetsDto.class);
				UserDto userDto = modelMapper.map(post.getUsers(), UserDto.class);
				tweetsDto.setUser(userDto);
					return tweetsDto;
					
				})
				.collect(Collectors.toList());
				
		
	TweetsResponse response = new TweetsResponse();
	 response.setContent(tweetsDtos);
	return response ;
	
		
		
	}

	@Override
	public TweetsResponse getTweetsbyUser(Integer id, Integer pageNumber, Integer pageSize)
			throws UserNotFoundException {
	
		
		
		Users users  = usersRepo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("Tweet not found with ID: " + id));
		
		
		Pageable p =  PageRequest.of(pageNumber, pageSize);
		
		
		
	Page<Tweets> pagetweet = tweetsRepo.findByUsers(users, p);
		
	List<Tweets> tweets = pagetweet.getContent();
		List<TweetsDto> tweetsDtos = tweets.stream()
				.map(post -> {
				TweetsDto tweetsDto =	modelMapper.map(post, TweetsDto.class);
				UserDto userDto = modelMapper.map(post.getUsers(), UserDto.class);
				tweetsDto.setUser(userDto);
					return tweetsDto;
					
				})
				.collect(Collectors.toList());
				
		
	TweetsResponse response = new TweetsResponse();
	 response.setContent(tweetsDtos);
	 response.setPageNumber(pagetweet.getNumber());
	 response.setPageSize(pagetweet.getSize());
	 response.setTotalElement(pagetweet.getTotalElements());
	 response.setTotalpages(pagetweet.getTotalPages());
	 response.setLastPage(pagetweet.isLast());
	return response ;
	
	}
	
}
