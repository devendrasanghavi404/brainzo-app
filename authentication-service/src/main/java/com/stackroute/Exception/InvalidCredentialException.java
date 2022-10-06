package com.stackroute.Exception;

public class InvalidCredentialException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidCredentialException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}