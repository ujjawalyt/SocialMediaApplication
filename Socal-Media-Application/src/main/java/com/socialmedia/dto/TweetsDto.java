package com.socialmedia.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TweetsDto {

	
	
	private int tweetId;
	
	private String content;
	
	private LocalDateTime createAt;
	
	private UserDto userDto;
}

