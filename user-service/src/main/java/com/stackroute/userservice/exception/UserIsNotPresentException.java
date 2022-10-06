package com.stackroute.userservice.exception;

public class UserIsNotPresentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserIsNotPresentException(String errorMessage) {
		super(errorMessage);
	}

}
