package com.stackroute.chatservice.exception;

public class InSufficientDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InSufficientDataException(String errorMessage) {
		super(errorMessage);
	}

}
