package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Likes;
import com.socialmedia.entity.Tweets;
import com.socialmedia.entity.Users;
@Repository
public interface LikeRepo extends  JpaRepository<Likes, Integer>{

	// Check if the user has already liked the tweet
	 boolean existsByUsersAndTweets(Users users, Tweets tweets);
}
