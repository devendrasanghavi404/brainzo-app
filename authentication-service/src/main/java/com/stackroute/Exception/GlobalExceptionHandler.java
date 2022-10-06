package com.stackroute.Exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ErrorInfo> handleExceptionForIdNotFound(InvalidCredentialException exception) {

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode("404");
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setTime(LocalDate.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
}