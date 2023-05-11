package com.socialmedia.exceptions;

public class TweetsNotFoundException extends Exception {

	public TweetsNotFoundException() {
		
	}
	public TweetsNotFoundException(String message) {
		super(message);
	}
}
