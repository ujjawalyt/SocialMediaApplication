package com.socialmedia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.socialmedia.entity.Users;
import com.socialmedia.repository.UsersRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	UsersRepo usersRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		  Users users =	this.usersRepo.findByEmail(username)
					.orElseThrow(()-> new UsernameNotFoundException("user is not found with this username" +username));
					
						
						return users;
						
	}

}
