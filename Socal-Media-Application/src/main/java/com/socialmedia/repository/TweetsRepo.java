package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Tweets;
@Repository
public interface TweetsRepo extends JpaRepository<Tweets, Integer> {

}
