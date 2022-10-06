package com.stackroute.userservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> handleEmailAlreadyExistsException(
			EmailAlreadyExistsException emailAlreadyExistsException, WebRequest request) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setMessage(emailAlreadyExistsException.getMessage());
		errorInfo.setTimestamp(new Date());
		errorInfo.setDescription(request.getDescription(false));

		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(InValidEmailException.class)
	public ResponseEntity<ErrorInfo> handleInValidEmailException(InValidEmailException inValidEmailException,
			WebRequest request) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setMessage(inValidEmailException.getMessage());
		errorInfo.setTimestamp(new Date());
		errorInfo.setDescription(request.getDescription(false));

		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(InValidContactNumberException.class)
	public ResponseEntity<ErrorInfo> handleInValidContactNumberException(
			InValidContactNumberException inValidContactNumberException, WebRequest request) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setMessage(inValidContactNumberException.getMessage());
		errorInfo.setTimestamp(new Date());
		errorInfo.setDescription(request.getDescription(false));

		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(InValidUserNameException.class)
	public ResponseEntity<ErrorInfo> handleInValidUserNameException(InValidUserNameException inValidUserNameException,
			WebRequest request) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setMessage(inValidUserNameException.getMessage());
		errorInfo.setTimestamp(new Date());
		errorInfo.setDescription(request.getDescription(false));

		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserIsNotPresentException.class)
	public ResponseEntity<ErrorInfo> handleUserIsNotPresentException(UserIsNotPresentException inValidUserNameException,
			WebRequest request) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setMessage(inValidUserNameException.getMessage());
		errorInfo.setTimestamp(new Date());
		errorInfo.setDescription(request.getDescription(false));

		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
