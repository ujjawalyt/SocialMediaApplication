package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.entity.Tweets;

public interface TweetsRepo extends JpaRepository<Tweets, Integer> {

}
