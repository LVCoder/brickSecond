package com.pmi.brick.exception;

@SuppressWarnings("serial")
public class EmailAlreadyExistsException extends Exception {
	public EmailAlreadyExistsException() {
	}

	// Constructor that accepts a message
	public EmailAlreadyExistsException(String message) {
		super(message);
	}

}
