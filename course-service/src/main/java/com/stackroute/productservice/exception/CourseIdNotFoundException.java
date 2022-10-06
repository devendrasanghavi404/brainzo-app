package com.stackroute.productservice.exception;

public class CourseIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public CourseIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
