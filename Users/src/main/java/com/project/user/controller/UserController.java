package com.project.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.beans.User;
import com.project.user.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	int count = 0;
	
	//create
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
	
	//create list of users
	@PostMapping("/list-users")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<User>> createListUser(@RequestBody List<User> users){
		List<User> listUsers = userService.createListUser(users);
		return ResponseEntity.status(HttpStatus.CREATED).body(listUsers);
	}
	
	//All users
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<User>> allUsers(){
		System.out.println(count++);
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
		
	//single user
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<User> getUser(@PathVariable String id){
		User user = userService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	//update user
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user){
		System.out.println(user.getId());
		User updateUser = userService.updateUser(id, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);
	}
	
	//delete user
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> deleteUser(@PathVariable String id){
		userService.deleteUser(id);
		return ResponseEntity.ok("User deleted"); 
	}
	
	
}
