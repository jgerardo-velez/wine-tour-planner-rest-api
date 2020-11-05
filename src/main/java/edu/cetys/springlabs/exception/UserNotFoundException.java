package edu.cetys.springlabs.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super("Invalid Credentials!");
	}
	
}
