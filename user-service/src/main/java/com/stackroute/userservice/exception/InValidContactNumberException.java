package com.stackroute.userservice.exception;

public class InValidContactNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InValidContactNumberException(String errorMessage) {
		super(errorMessage);
	}

}
