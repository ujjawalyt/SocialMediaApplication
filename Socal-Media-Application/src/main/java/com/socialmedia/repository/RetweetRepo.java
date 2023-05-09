package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.entity.Retweets;

public interface RetweetRepo  extends JpaRepository<Retweets, Integer>{

}
