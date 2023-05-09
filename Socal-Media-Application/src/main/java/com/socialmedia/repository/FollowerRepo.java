package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Follower;

@Repository
public interface FollowerRepo extends JpaRepository<Follower, Integer> {

}
