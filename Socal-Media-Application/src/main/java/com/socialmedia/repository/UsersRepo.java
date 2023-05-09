package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.entity.Users;
@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

  
	 Users  findByEmail(String email);
	
}
