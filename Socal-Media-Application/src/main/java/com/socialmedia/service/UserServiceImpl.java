package com.socialmedia.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.socialmedia.dto.UserDto;
import com.socialmedia.entity.Users;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.repository.UsersRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public UserDto addNewUser(UserDto userDto) throws UserNotFoundException {
		
		Users users = usersRepo.findByEmail(userDto.getEmail());
		if(users!=null) {
			throw new UserNotFoundException("User is already present with this email"+ userDto.getEmail());
		}
		
     
		Users user = modelMapper.map(userDto,Users.class);
		user.setCreateAt(LocalDateTime.now());
	
	    Users savedUSers =usersRepo.save(user);
	
	    return modelMapper.map(savedUSers, UserDto.class);
      

		
	}

	
}
