package com.capgemini.exceptions;

public class NoSuchEmailException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchEmailException(String message) {
		super(message);
	}
	

}
