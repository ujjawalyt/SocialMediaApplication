package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.entity.Likes;

public interface LikeRepo extends  JpaRepository<Likes, Integer>{

}
