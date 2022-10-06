package com.stackroute.chatservice.exception;

public class CommentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommentNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
