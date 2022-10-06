package com.stackroute.chatservice.exception;

public class CommentIdNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommentIdNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
