package com.socialmedia.service;

import java.time.LocalDateTime;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.socialmedia.constant.AppConstant;
import com.socialmedia.dto.UserDto;
import com.socialmedia.entity.Role;
import com.socialmedia.entity.Users;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.repository.RoleRepo;
import com.socialmedia.repository.UsersRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public UserDto addNewUser(UserDto userDto) throws UserNotFoundException {
		
		Optional<Users> existingUser = usersRepo.findByEmail(userDto.getEmail());
		if (existingUser.isPresent()) {
			throw new UserNotFoundException("User is already present with this email: " + userDto.getEmail());
		}

	
		Users user = modelMapper.map(userDto, Users.class);
		user.setCreateAt(LocalDateTime.now());
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role normalUserRole = roleRepo.findById(AppConstant.NORMAL_USER)
				.orElseThrow(() -> new RuntimeException("Normal User role not found"));

		user.getRoles().add(normalUserRole);

		
		Users savedUser = usersRepo.save(user);

		
		return modelMapper.map(savedUser, UserDto.class);
      

		
	}

	@Override
	public UserDto addNewAdmin(UserDto userDto) throws UserNotFoundException {
		
		
		Optional<Users> existingUser = usersRepo.findByEmail(userDto.getEmail());
		if (existingUser.isPresent()) {
			throw new UserNotFoundException("User is already present with this email: " + userDto.getEmail());
		}

	
		Users user = modelMapper.map(userDto, Users.class);
		user.setCreateAt(LocalDateTime.now());
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role adminUserRole = roleRepo.findById(AppConstant.ADMIN_USER)
				.orElseThrow(() -> new RuntimeException("Admin User role not found"));

		user.getRoles().add(adminUserRole);

		
		Users savedUser = usersRepo.save(user);

		
		return modelMapper.map(savedUser, UserDto.class);
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer id) throws UserNotFoundException {
	
		Users isPresent = usersRepo.findById(id)
				.orElseThrow(()->  new UserNotFoundException("User with this userId is not found"+id));

		isPresent.setBio(userDto.getBio());
		isPresent.setDisplayName(userDto.getDisplayName());
		isPresent.setEmail(userDto.getEmail());
		isPresent.setPassword(passwordEncoder.encode(userDto.getPassword()));
		isPresent.setUsername(userDto.getUsername());
		
	Users isSaved =	usersRepo.save(isPresent);
	return modelMapper.map(isSaved, UserDto.class);
		
		
		
		
	}

	@Override
	public UserDto getUserById(Integer id) throws UserNotFoundException {
		
		Users isPresent = usersRepo.findById(id)
				.orElseThrow(()->  new UserNotFoundException("User with this userId is not found"+id));
		
		return modelMapper.map(isPresent, UserDto.class);
		
	}

	@Override
	public String deleteUserById(Integer id) throws UserNotFoundException {
		Users isPresent = usersRepo.findById(id)
				.orElseThrow(()->  new UserNotFoundException("User with this userId is not found"+id));
		
		
		isPresent.getRoles().clear();
		usersRepo.delete(isPresent);
		
		
		return "User data Deleted successfully..!";

		
	}

	
}
