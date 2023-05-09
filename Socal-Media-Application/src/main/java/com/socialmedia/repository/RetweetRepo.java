package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Retweets;
@Repository
public interface RetweetRepo  extends JpaRepository<Retweets, Integer>{

}
