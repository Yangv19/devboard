package com.vincentdevboard.app.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import com.vincentdevboard.app.exceptions.MultipleException;
import com.vincentdevboard.app.exceptions.SingleException;

@ControllerAdvice
public class ResponseExceptionHandler {
	@ExceptionHandler(MultipleException.class)
	public ResponseEntity<MultipleExceptionResponse> handleMultipleException(MultipleException e) {	
		MultipleExceptionResponse res = new MultipleExceptionResponse(e.getErrors());
		return new ResponseEntity<MultipleExceptionResponse>(res, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SingleException.class)
	public ResponseEntity<SingleExceptionResponse> handleSingleException(SingleException e) {	
		SingleExceptionResponse res = new SingleExceptionResponse(e.getMessage());
		return new ResponseEntity<SingleExceptionResponse>(res, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<SingleExceptionResponse> handleMissingTokenException(MissingRequestHeaderException e) {
		SingleExceptionResponse res = new SingleExceptionResponse("No token, authorization denied");
		return new ResponseEntity<SingleExceptionResponse>(res, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<SingleExceptionResponse> handleMissingBodyException(HttpMessageNotReadableException e) {
		SingleExceptionResponse res = new SingleExceptionResponse("No request body found");
		return new ResponseEntity<SingleExceptionResponse>(res, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<SingleExceptionResponse> handleMissingParameter(HttpRequestMethodNotSupportedException e) {
		SingleExceptionResponse res = new SingleExceptionResponse("Required parameter not found");
		return new ResponseEntity<SingleExceptionResponse>(res, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MultipartException.class)
	public ResponseEntity<SingleExceptionResponse> handleMissingParameter(MultipartException e) {
		SingleExceptionResponse res = new SingleExceptionResponse("Required parameter not found");
		return new ResponseEntity<SingleExceptionResponse>(res, HttpStatus.BAD_REQUEST);
	}
}
