package com.angular.springboot.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {

		super(message);
	}
}
