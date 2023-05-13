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
	
	@ExceptionHandler(FollowerNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myFNFExceptionHandler( FollowerNotFoundException fn ,WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(fn.getMessage());
		error.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LikeNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myLNFExceptionHandler( LikeNotFoundException ln ,WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ln.getMessage());
		error.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LikeAlreadyExistsException.class)
	public ResponseEntity<MyErrorDetails> myLAEExceptionHandler( LikeAlreadyExistsException la ,WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(la.getMessage());
		error.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(RetweetNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myRNFExceptionHandler( RetweetNotFoundException rn ,WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(rn.getMessage());
		error.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RetweetAlreadyExistsException.class)
	public ResponseEntity<MyErrorDetails> myRNFExceptionHandler( RetweetAlreadyExistsException rn ,WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(rn.getMessage());
		error.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
  
}
