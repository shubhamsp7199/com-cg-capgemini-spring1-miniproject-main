package com.capgemini.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(NoSuchConsumerNumberException.class)
	public ResponseEntity<Object> handleNoSuchConsumerNumberException() {
		LOG.error("handleNoSuchConsumerNumberException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Consumer Number is not available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchMobileNumberException.class)
	public ResponseEntity<Object> handleNoSuchMobileNumberException() {
		LOG.error("handleNoSuchMobileNumberException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This mobile Number is not available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchEmailException.class)
	public ResponseEntity<Object> handleNoSuchEmailException() {
		LOG.error("handleNoSuchEmailException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This email is not available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchDateRangeException.class)
	public ResponseEntity<Object> handleNoSuchDateRangeException() {
		LOG.error("handleNoSuchDateRangeException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This date range is not available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

}
