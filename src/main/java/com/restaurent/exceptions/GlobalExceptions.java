package com.restaurent.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptions.class);
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception ex) {
		log.info("Resource not found Exception");
		ErrorResponse errResp = new ErrorResponse();
		errResp.setStatusCode(HttpStatus.NOT_FOUND);
		errResp.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errResp, HttpStatus.OK);
	}
	
	
	
	
}
