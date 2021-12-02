package com.capgemini.exceptions;

public class NoSuchConsumerNumberException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoSuchConsumerNumberException(String message) {
		super(message);
	}

}
