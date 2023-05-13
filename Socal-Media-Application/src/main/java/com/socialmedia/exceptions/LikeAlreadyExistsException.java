package com.socialmedia.exceptions;

public class LikeAlreadyExistsException extends Exception{

	public LikeAlreadyExistsException() {
		
	};
	
	
      public LikeAlreadyExistsException(String message) {
		super(message);
	}
}
