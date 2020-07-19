package com.demo.user.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3892114115709093137L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
