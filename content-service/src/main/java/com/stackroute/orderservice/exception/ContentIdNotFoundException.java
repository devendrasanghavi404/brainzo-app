package com.stackroute.orderservice.exception;

public class ContentIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public ContentIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
