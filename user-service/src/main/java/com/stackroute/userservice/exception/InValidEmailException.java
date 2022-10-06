package com.stackroute.userservice.exception;

public class InValidEmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InValidEmailException(String errorMessage) {
		super(errorMessage);
	}
}
