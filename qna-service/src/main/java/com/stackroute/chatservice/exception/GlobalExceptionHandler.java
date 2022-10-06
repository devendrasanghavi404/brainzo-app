package com.stackroute.chatservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InSufficientDataException.class)
	public ResponseEntity<ErrorInfo> handleInSufficientDataException(InSufficientDataException exception,
			WebRequest request) {

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setTimestamp(new Date());
		errorInfo.setMessage(exception.getMessage());
		errorInfo.setDescription(request.getDescription(false));
		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(CommentNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleCommentNotFoundException(CommentNotFoundException exception,
			WebRequest request) {

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setTimestamp(new Date());
		errorInfo.setMessage(exception.getMessage());
		errorInfo.setDescription(request.getDescription(false));
		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(CommentIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleCommentIdNotFoundException(CommentIdNotFoundException exception,
			WebRequest request) {

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setTimestamp(new Date());
		errorInfo.setMessage(exception.getMessage());
		errorInfo.setDescription(request.getDescription(false));
		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
