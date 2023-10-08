package com.project.user.services;

import java.util.List;

import com.project.user.beans.User;


public interface UserService {

	//create
	User createUser(User user);
	
	//create list users
	List<User> createListUser(List<User> user);
	
	//get all users
	List<User> getAllUsers();
	
	//get single user
	User getUser(String id);
	
	//update user
	User updateUser(String id, User user);
	
	//delete user
	void deleteUser(String id);
	
	
	
}
