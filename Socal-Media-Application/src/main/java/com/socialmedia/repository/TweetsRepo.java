package com.socialmedia.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Tweets;
import com.socialmedia.entity.Users;
@Repository
public interface TweetsRepo extends JpaRepository<Tweets, Integer> {

	List<Tweets> findByContentContainingIgnoreCase(String key);
	List<Tweets> findByUsers(Users users);
	
	Page<Tweets> findByUsers(Users users, Pageable p);
}
