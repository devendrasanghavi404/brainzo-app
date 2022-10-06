package com.stackroute.userservice.exception;

public class InValidUserNameException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InValidUserNameException(String errorMessage) {
		super(errorMessage);
	}

}
