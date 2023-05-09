package com.socialmedia.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorDetails {

	
	private LocalDateTime timestamp;
	private String message;
	private String description;
	
	
}
