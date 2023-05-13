package com.socialmedia.exceptions;

public class RetweetAlreadyExistsException extends Exception {

	public RetweetAlreadyExistsException() {
		
	}
	
	public RetweetAlreadyExistsException(String message) {
		super(message);
	}
}
