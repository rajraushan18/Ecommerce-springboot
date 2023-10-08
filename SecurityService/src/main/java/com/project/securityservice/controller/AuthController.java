package com.project.securityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.securityservice.dto.AuthRequest;
import com.project.securityservice.entities.UserCredential;
import com.project.securityservice.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	//7. auth controller
	@Autowired
	private AuthService authService;
	
	//this is used to only give token to those who is present in the db
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public String addUser(@RequestBody UserCredential user) {
		return authService.saveUser(user);
	}
	
	@PostMapping("/token")
	public String getToken(@RequestBody AuthRequest authRequest) {
		
		//this will autheticate the user but it need to connect to db
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authenticate.isAuthenticated()) {
			return authService.generateToken(authRequest.getUsername());			
		}else {
			throw new RuntimeException("Not valid user!");
		}
		
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		authService.validateToken(token);
		return "valid token";
	}
	
	
}
