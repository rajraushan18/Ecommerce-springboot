package com.project.productdetails.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("resource not found Exception");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	
}
