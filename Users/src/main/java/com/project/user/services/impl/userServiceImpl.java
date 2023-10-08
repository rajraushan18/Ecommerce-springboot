package com.project.user.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.user.beans.User;
import com.project.user.exceptions.ResourceNotFoundException;
import com.project.user.repo.UserRepository;
import com.project.user.services.UserService;

@Service
public class userServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	//create
	@Override
	public User createUser(User user) {
		//generate unique id
		String randomUUID = UUID.randomUUID().toString();
		user.setId(randomUUID);
		
		String password = user.getPassword();
		String hashedPassword = encoder.encode(password);
		user.setPassword(hashedPassword);
		
		return userRepository.save(user);
	}

	//get all users
	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	//get single user
	@Override
	public User getUser(String id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user with given id doen't found!!"));
		return user;
	}

	//update user
	@Override
	public User updateUser(String id, User user) {
//		String id = user.getId();
		//this will return the existing user with the same id
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isPresent()) {
			//it will provide current data with the user id
			User existingUser = userOptional.get();
			
			//update data
			existingUser.setUsername(user.getUsername());
			existingUser.setPassword(user.getPassword());
			existingUser.setRole(user.getRole());
			
			return userRepository.save(existingUser);
		}else {
			throw new ResourceNotFoundException("No user with given id found!!");
		}
	}

	//delete user
	@Override
	public void deleteUser(String id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
		}else {
			throw new ResourceNotFoundException("no user found with given id!!");
		}
		
	}
	
	//create multiple users
	@Override
	public List<User> createListUser(List<User> users) {
		for(User user : users) {
			String randomUID = UUID.randomUUID().toString();
			user.setId(randomUID);
			
			String password = user.getPassword();
			String hashedPassword = encoder.encode(password);
			user.setPassword(hashedPassword);
			
			userRepository.save(user);
		}
		return users;
	}
	
	
}
