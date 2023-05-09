package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Likes;
@Repository
public interface LikeRepo extends  JpaRepository<Likes, Integer>{

}
