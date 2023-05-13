package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.entity.Follower;
import com.socialmedia.entity.Users;
import com.socialmedia.exceptions.FollowerNotFoundException;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.repository.FollowerRepo;
import com.socialmedia.repository.UsersRepo;

@Service
public class FollowerServiceImpl implements FollowerService{

	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private FollowerRepo followerRepo;
	
	@Override
	public String addFollowerToUser(Integer userId) throws UserNotFoundException {
		
		Users users = usersRepo.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("user not found with this userid" + userId));
		
		// Create a new Follower instance
        Follower follower = new Follower();
        follower.setUsers(users);
        follower.setFollowerUser(users);

        // Save the Follower entity
        followerRepo.save(follower);

        return "Follower added successfully";
		
	
	}

	@Override
	public String removeFollowerFromUser(Integer userId , Integer followerId )
			throws UserNotFoundException,FollowerNotFoundException {
		Users users = usersRepo.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("user not found with this userid" + userId));
		
		Follower follower = followerRepo.findById(followerId)
				.orElseThrow(()->new FollowerNotFoundException("Follower Not Found With This followerId"+ followerId));
		
		
		followerRepo.deleteById(followerId);
		return "Follower Removed Successfully...!";
		
	}

	
}
