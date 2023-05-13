package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Retweets;
import com.socialmedia.entity.Tweets;
import com.socialmedia.entity.Users;
@Repository
public interface RetweetRepo  extends JpaRepository<Retweets, Integer>{

	 boolean existsByUsersAndTweets(Users users, Tweets tweets);
}
