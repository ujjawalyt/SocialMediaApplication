package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.entity.Follower;

public interface FollowerRepo extends JpaRepository<Follower, Integer> {

}
