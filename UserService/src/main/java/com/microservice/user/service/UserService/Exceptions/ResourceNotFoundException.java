package com.microservice.user.service.UserService.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException() {
		super("Resource not found on server"); //default msg
	}
	
	public ResourceNotFoundException(String message) {
		super(message); //if msg given by user
	}

}
