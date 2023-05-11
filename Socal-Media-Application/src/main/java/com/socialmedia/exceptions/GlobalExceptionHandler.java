package com.socialmedia.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage("Validation Error.!");
		error.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myUNFExceptionHandler(UserNotFoundException us ,WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(us.getMessage());
		error.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(TweetsNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myTWFExceptionHandler(TweetsNotFoundException tnfe ,WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(tnfe.getMessage());
		error.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
  
}
