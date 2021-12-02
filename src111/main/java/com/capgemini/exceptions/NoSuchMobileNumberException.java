package com.capgemini.exceptions;

public class NoSuchMobileNumberException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoSuchMobileNumberException(String message) {
		super(message);
	}

}
