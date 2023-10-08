package com.project.user.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("resource not found Exception");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	
	
}
