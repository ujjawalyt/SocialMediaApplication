package com.socialmedia.service;

import org.springframework.stereotype.Service;

import com.socialmedia.exceptions.FollowerNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;

@Service
public interface FollowerService {

	
	public String addFollowerToUser(Integer userId) throws UserNotFoundException;
	public String removeFollowerFromUser(Integer userId, Integer followerId) 
			throws UserNotFoundException ,FollowerNotFoundException;
}
